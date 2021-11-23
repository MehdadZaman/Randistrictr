package mothballs.randistrictr.controller;

import mothballs.randistrictr.model.DistrictingPlan;
import mothballs.randistrictr.model.DistrictingPlanStatistics;
import mothballs.randistrictr.service.AlgorithmService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("randistrictr/algorithm")
@RestController
public class AlgorithmController {

    @Autowired
    AlgorithmService algorithmService;

    // run simulated annealing algorithm
    @GetMapping("/run")
    public JSONObject runAlgorithm(@RequestParam(value = "stateName") double maxPopDiff,
                                  @RequestParam(value = "minOpportunity") int minOpportunity,
                                  @RequestParam(value = "maxOpportunity") int maxOpportunity) {
        System.out.println("PINGED Run Algorithm");
        JSONObject districtingPlanJSONObject = algorithmService.getImprovedDistrictingPlan(maxPopDiff, minOpportunity, maxOpportunity);
        System.out.println("DONE Run Algorithm");
        return districtingPlanJSONObject;
    }

    @GetMapping("/stop")
    public void stopAlgorithm() {
        algorithmService.stopAlgorithm();
    }

    @GetMapping("/getCurrentDistrictingPlan")
    public JSONObject getCurrentDistrictingPlan() {
        return algorithmService.getCurrentDistrictingPlan();
    }

    @GetMapping("/getCurrentDistrictingStatistics")
    public DistrictingPlanStatistics getCurrentDistrictingStatistics() {
        return algorithmService.getCurrentDistrictingStatistics();
    }

    @GetMapping("/getCurrentNumberOfIterations")
    public int getCurrentNumberOfIterations() {
        return algorithmService.getCurrentNumberOfIterations();
    }
}
