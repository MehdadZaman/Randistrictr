package mothballs.randistrictr.controller;

import mothballs.randistrictr.model.DistrictingPlanStatistics;
import mothballs.randistrictr.model.Population;
import mothballs.randistrictr.service.DistrictService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("randistrictr/select")
@RestController
public class StateSelectorController {
    @Autowired
    DistrictService districtService;

    @GetMapping("/state/population")
    public Population getStatePopulation(@RequestParam(value = "stateName") String stateName) {
        System.out.println("PINGED");
        districtService.selectState(stateName);
        Population statePopulation = districtService.getPopulation(stateName);
        System.out.println("DONE");
        return statePopulation;
    }

    @GetMapping("/state/enactedDistricting")
    public JSONObject getEnactedDistricting() {
        System.out.println("PINGED");
        JSONObject jsonObject = districtService.getEnactedDistricting();
        System.out.println("DONE");
        return jsonObject;
    }

    @GetMapping("/state/enactedDistrictingPlanStatistics")
    public DistrictingPlanStatistics getEnactedDistrictPlanStatistics() {
        return districtService.getEnactedDistrictingPlanStatistics();
    }

    @GetMapping("/state/allDistrictingPlanStatistics")
    public List<DistrictingPlanStatistics> getAllDistrictingPlanStatistics() {
        System.out.println("PINGED");
        List<DistrictingPlanStatistics> allDistrictingPlanStatistics = districtService.getAllDistrictingPlanStatistics();
        System.out.println("DONE");
        return allDistrictingPlanStatistics;
    }

    @GetMapping("/state/districting")
    public JSONObject getStateRedistricting(@RequestParam(value = "redistrictNumber") int redistrictNumber) {
        return districtService.getDistrictingPlan(redistrictNumber);
    }

    @GetMapping("/districting/districtPlanStatistics")
    public DistrictingPlanStatistics getDistrictPlanStatistics() {
        return districtService.getDistrictingPlanStatistics();
    }
}
