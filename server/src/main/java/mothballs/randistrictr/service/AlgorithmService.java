package mothballs.randistrictr.service;

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

    public JSONObject getImprovedDistrictingPlan() {
        runAlgorithm();
        DistrictingPlan improvedDistrictingPlan = districtService.getCurrentDistrictingPlan();
        return censusBlockService.getDistrictingJSON(improvedDistrictingPlan);
    }


    private void runAlgorithm() {
        DistrictingPlan currentDistrictingPlan = districtService.getCurrentDistrictingPlan();
        for (currentIteration = 0; currentIteration < MAX_ITERATIONS; currentIteration++) {
            DistrictingPlan clonedDistrictingPlan = currentDistrictingPlan.deepClone();
            District district = currentDistrictingPlan.selectDistrict();
            district.modifyDistrict();
            // update districting plan statistics
            currentDistrictingPlan.recalculateMeasures();
            // TODO: get objective function score
            if (isImproved(clonedDistrictingPlan.getDistrictingPlanStatistics(),
                    currentDistrictingPlan.getDistrictingPlanStatistics())) {
                districtService.setCurrentDistrictingPlan(currentDistrictingPlan);
            } else {
                districtService.setCurrentDistrictingPlan(clonedDistrictingPlan);
            }
        }
    }

    private boolean isImproved(DistrictingPlanStatistics originalDistrictingPlanStatistics,
                               DistrictingPlanStatistics updatedDistrictingPlanStatistics) {

        return false;
    }
}
