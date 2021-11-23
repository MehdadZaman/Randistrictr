package mothballs.randistrictr.service;

import mothballs.randistrictr.model.CensusBlock;
import mothballs.randistrictr.model.District;
import mothballs.randistrictr.model.DistrictingPlan;
import mothballs.randistrictr.model.DistrictingPlanStatistics;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlgorithmService {

    @Autowired
    DistrictService districtService;

    @Autowired
    CensusBlockService censusBlockService;

    private int currentIteration;
    private final int MAX_ITERATIONS = 100000;

    public JSONObject getImprovedDistrictingPlan(double maxPopDiff, int minOpportunity, int maxOpportunity) {
        runAlgorithm(minOpportunity, maxOpportunity);
        DistrictingPlan improvedDistrictingPlan = districtService.getCurrentDistrictingPlan();
        return censusBlockService.getDistrictingJSON(improvedDistrictingPlan);
    }


    private void runAlgorithm(int minOpportunity, int maxOpportunity) {
        DistrictingPlan currentDistrictingPlan = districtService.getCurrentDistrictingPlan();
        for (currentIteration = 0; currentIteration < MAX_ITERATIONS; currentIteration++) {
            // DistrictingPlan clonedDistrictingPlan = currentDistrictingPlan.deepClone();

//            District selectDistrict = currentDistrictingPlan.selectDistrict();
//            CensusBlock censusBlockToMove = district.selectCensusBlock();
//            makeMove(censusBlockToMove);

//            double currPopDiff

            // update districting plan statistics
            currentDistrictingPlan.recalculateMeasures();

//            if (isValidMove(clonedDistrictingPlan.getDistrictingPlanStatistics(),
//                    currentDistrictingPlan.getDistrictingPlanStatistics(), minOpportunity, maxOpportunity)) {
//                districtService.setCurrentDistrictingPlan(currentDistrictingPlan);
//            } else {
//                districtService.setCurrentDistrictingPlan(clonedDistrictingPlan);
//            }
        }
    }

//    private boolean isImproved(DistrictingPlanStatistics originalDistrictingPlanStatistics,
//                               DistrictingPlanStatistics updatedDistrictingPlanStatistics,
//                               int minOpportunity, int maxOpportunity) {
//        if(updatedDistrictingPlanStatistics.getNumOpportunityDistricts())
//
//        return false;
//    }


}
