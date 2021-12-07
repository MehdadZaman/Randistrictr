package mothballs.randistrictr.service;

import mothballs.randistrictr.model.CensusBlock;
import mothballs.randistrictr.model.District;
import mothballs.randistrictr.model.DistrictingPlan;
import mothballs.randistrictr.model.DistrictingPlanStatistics;
import mothballs.randistrictr.enums.PopulationMeasure;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@EnableAsync
@Service
public class AlgorithmService {

    @Autowired
    DistrictService districtService;
    @Autowired
    DissolvingService dissolvingService;

    private int currentIteration;
    private final int MAX_ITERATIONS = 10000000;

    @Async
    public void startImprovedDistrictingPlanAlgorithm(double maxPopDiff) {
        runAlgorithm(maxPopDiff, districtService.getPopulationMeasure());
    }

    private void runAlgorithm(double maxPopDiff, PopulationMeasure populationMeasure) {
        HashSet<CensusBlock> censusBlocksMoved = new HashSet<>();
        DistrictingPlan currentDistrictingPlan = districtService.getCurrentDistrictingPlan();

        // Instantiating district data structures
        List<District> districts = currentDistrictingPlan.getDistricts();
        currentDistrictingPlan.instantiateIDMappings();

        for(District district : districts) {
            if(!district.dataStructuresInstantiated()) {
                currentDistrictingPlan.instantiateDataStructures(district);
            }
        }

        for (currentIteration = 0; currentIteration < MAX_ITERATIONS; currentIteration++) {
            if(populationMeasure == PopulationMeasure.TOTAL) {
                if(currentDistrictingPlan.getDistrictingPlanStatistics().getTotalPopulationScore() <= maxPopDiff) {
                    currentIteration = MAX_ITERATIONS;
                    break;
                }
            }
            else if(populationMeasure == PopulationMeasure.CVAP) {
                if(currentDistrictingPlan.getDistrictingPlanStatistics().getCvapPopulationScore() <= maxPopDiff) {
                    currentIteration = MAX_ITERATIONS;
                    break;
                }
            }
            else if(populationMeasure == PopulationMeasure.VAP) {
                if (currentDistrictingPlan.getDistrictingPlanStatistics().getVapPopulationScore() <= maxPopDiff) {
                    currentIteration = MAX_ITERATIONS;
                    break;
                }
            }
            District selectedDistrict = currentDistrictingPlan.selectDistrict(districtService.getPopulationMeasure());
            if(selectedDistrict == null) continue;
            CensusBlock censusBlockToMove = selectedDistrict.selectCensusBlock(districtService.getPopulationMeasure());
            if(censusBlockToMove == null) continue;
            currentDistrictingPlan.makeMove(censusBlockToMove);
            DistrictingPlanStatistics oldDistrictingPlanStatistics = currentDistrictingPlan.getDistrictingPlanStatistics().deepClone();
            currentDistrictingPlan.recalculateMeasures();
            if (!isValidMove(oldDistrictingPlanStatistics, currentDistrictingPlan.getDistrictingPlanStatistics())) {
                currentDistrictingPlan.makeMove(censusBlockToMove);
                currentDistrictingPlan.setDistrictingPlanStatistics(oldDistrictingPlanStatistics);
            }
            else {
                censusBlocksMoved.add(censusBlockToMove);
            }
        }

        // Printing out moved censusblocks
        System.out.println(censusBlocksMoved.size());
        for(CensusBlock censusBlock : censusBlocksMoved) {
            System.out.println(censusBlock.getGeoID20());
            System.out.println("BEFORE: " + censusBlock.getAdjacentCongressionalDistrict());
            System.out.println("AFTER: " + censusBlock.getCongressionalDistrict());
        }
    }

    private boolean isValidMove(DistrictingPlanStatistics originalDistrictingPlanStatistics, DistrictingPlanStatistics updatedDistrictingPlanStatistics) {
        if(districtService.getPopulationMeasure() == PopulationMeasure.TOTAL) {
            return (updatedDistrictingPlanStatistics.getTotalPopulationScore() < originalDistrictingPlanStatistics.getTotalPopulationScore());
        }
        else if(districtService.getPopulationMeasure() == PopulationMeasure.CVAP) {
            return (updatedDistrictingPlanStatistics.getCvapPopulationScore() < originalDistrictingPlanStatistics.getCvapPopulationScore());
        }
        else if(districtService.getPopulationMeasure() == PopulationMeasure.VAP) {
            return (updatedDistrictingPlanStatistics.getVapPopulationScore() < originalDistrictingPlanStatistics.getVapPopulationScore());
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