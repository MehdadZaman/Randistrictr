package mothballs.randistrictr.controller;

import mothballs.randistrictr.model.DistrictingPlan;
import mothballs.randistrictr.service.AlgorithmService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("randistrictr")
@RestController
public class AlgorithmController {

    @Autowired
    AlgorithmService algorithmService;

    // run simulated annealing algorithm
    @GetMapping("/run-algorithm")
    public JSONObject runAlgorithm() {
        System.out.println("PINGED Run Algorithm");
        JSONObject districtingPlanJSONObject = algorithmService.getImprovedDistrictingPlan();
        System.out.println("DONE Run Algorithm");
        return districtingPlanJSONObject;
    }
}
