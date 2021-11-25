package mothballs.randistrictr.service;

import mothballs.randistrictr.model.CensusBlock;
import mothballs.randistrictr.model.District;
import mothballs.randistrictr.model.DistrictingPlan;
import mothballs.randistrictr.model.DistrictingPlanStatistics;
import mothballs.randistrictr.object.PopulationMeasure;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlgorithmService {

    @Autowired
    DistrictService districtService;

    @Autowired
    DissolvingService dissolvingService;

    private int currentIteration;
    private final int MAX_ITERATIONS = 100000;

    @Async
    public void startImprovedDistrictingPlanAlgorithm(double maxPopDiff, int minOpportunity, int maxOpportunity) {
        runAlgorithm(minOpportunity, maxOpportunity);
    }

    private void runAlgorithm(int minOpportunity, int maxOpportunity) {
        DistrictingPlan currentDistrictingPlan = districtService.getCurrentDistrictingPlan();

        // Instantiating district data structures
        List<District> districts = currentDistrictingPlan.getDistricts();
        for(District district : districts) {
            if(!district.dataStructuresInstantiated()) {
                currentDistrictingPlan.instantiateDataStructures(district);
            }
        }

        for (currentIteration = 0; currentIteration < MAX_ITERATIONS; currentIteration++) {
            District selectedDistrict = currentDistrictingPlan.selectDistrict();

            CensusBlock censusBlockToMove = selectedDistrict.selectCensusBlock();
            currentDistrictingPlan.makeMove(censusBlockToMove);

            DistrictingPlanStatistics oldDistrictingPlanStatistics = currentDistrictingPlan.getDistrictingPlanStatistics().deepClone();
            currentDistrictingPlan.recalculateMeasures();

            if (!isValidMove(oldDistrictingPlanStatistics, currentDistrictingPlan.getDistrictingPlanStatistics(), minOpportunity, maxOpportunity)) {
                currentDistrictingPlan.makeMove(censusBlockToMove);
                currentDistrictingPlan.setDistrictingPlanStatistics(oldDistrictingPlanStatistics);
            }
        }
    }

    private boolean isValidMove(DistrictingPlanStatistics originalDistrictingPlanStatistics, DistrictingPlanStatistics updatedDistrictingPlanStatistics, int minOpportunity, int maxOpportunity) {
        if(districtService.getPopulationMeasure() == PopulationMeasure.TOTAL) {
            if (updatedDistrictingPlanStatistics.getTotalNumOpportunityDistricts() < minOpportunity || updatedDistrictingPlanStatistics.getTotalNumOpportunityDistricts() > maxOpportunity) {
                return false;
            }
            return (updatedDistrictingPlanStatistics.getTotalAbsoluteDifferenceInPopulation() < originalDistrictingPlanStatistics.getTotalAbsoluteDifferenceInPopulation());
        }
        else if(districtService.getPopulationMeasure() == PopulationMeasure.CVAP) {
            if (updatedDistrictingPlanStatistics.getCvapNumOpportunityDistricts() < minOpportunity || updatedDistrictingPlanStatistics.getCvapNumOpportunityDistricts() > maxOpportunity) {
                return false;
            }
            return (updatedDistrictingPlanStatistics.getCvapAbsoluteDifferenceInPopulation() < originalDistrictingPlanStatistics.getCvapAbsoluteDifferenceInPopulation());
        }
        else if(districtService.getPopulationMeasure() == PopulationMeasure.VAP) {
            if (updatedDistrictingPlanStatistics.getVapNumOpportunityDistricts() < minOpportunity || updatedDistrictingPlanStatistics.getVapNumOpportunityDistricts() > maxOpportunity) {
                return false;
            }
            return (updatedDistrictingPlanStatistics.getVapAbsoluteDifferenceInPopulation() < originalDistrictingPlanStatistics.getVapAbsoluteDifferenceInPopulation());
        }

        return false;
    }

    public void stopAlgorithm() {
        this.currentIteration = MAX_ITERATIONS;
    }

    public JSONObject getCurrentDistrictingPlan() {
        return dissolvingService.getDistrictingJSON(districtService.getCurrentDistrictingPlan());
    }

    public DistrictingPlanStatistics getCurrentDistrictingStatistics() {
        return districtService.getCurrentDistrictingPlan().getDistrictingPlanStatistics();
    }

    public int getCurrentNumberOfIterations() {
        return currentIteration;
    }

    public String checkAlgorithmStatus() {
        if(currentIteration == MAX_ITERATIONS) {
            return "Complete";
        }
        return "Incomplete";
    }
}
