package mothballs.randistrictr.service;

import mothballs.randistrictr.model.CensusBlock;
import mothballs.randistrictr.model.District;
import mothballs.randistrictr.model.DistrictingPlan;
import mothballs.randistrictr.model.DistrictingPlanStatistics;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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

    public JSONObject getImprovedDistrictingPlan(double maxPopDiff, int minOpportunity, int maxOpportunity) {
        runAlgorithm(minOpportunity, maxOpportunity);
        DistrictingPlan improvedDistrictingPlan = districtService.getCurrentDistrictingPlan();
        return dissolvingService.getDistrictingJSON(improvedDistrictingPlan);
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
        if(updatedDistrictingPlanStatistics.getNumOpportunityDistricts() < minOpportunity || updatedDistrictingPlanStatistics.getNumOpportunityDistricts() > maxOpportunity) {
            return false;
        }

        return (updatedDistrictingPlanStatistics.getAbsoluteDifferenceInPopulation() < originalDistrictingPlanStatistics.getAbsoluteDifferenceInPopulation());
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
}
