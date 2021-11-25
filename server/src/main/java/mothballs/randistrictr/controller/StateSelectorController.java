package mothballs.randistrictr.controller;

import mothballs.randistrictr.model.DistrictingPlanStatistics;
import mothballs.randistrictr.model.Population;
import mothballs.randistrictr.enums.Basis;
import mothballs.randistrictr.enums.PopulationMeasure;
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
        districtService.selectState(stateName);
        Population statePopulation = districtService.getPopulation(stateName);
        return statePopulation;
    }

    @GetMapping("/state/enactedDistricting")
    public JSONObject getEnactedDistricting() {
        JSONObject jsonObject = districtService.getEnactedDistricting();
        return jsonObject;
    }

    @GetMapping("/state/enactedDistrictingPlanStatistics")
    public DistrictingPlanStatistics getEnactedDistrictPlanStatistics() {
        return districtService.getEnactedDistrictingPlanStatistics();
    }

    @GetMapping("/state/allDistrictingPlanStatistics")
    public List<DistrictingPlanStatistics> getAllDistrictingPlanStatistics() {
        List<DistrictingPlanStatistics> allDistrictingPlanStatistics = districtService.getAllDistrictingPlanStatistics();
        return allDistrictingPlanStatistics;
    }

    @GetMapping("/state/districting")
    public JSONObject getStateRedistricting(@RequestParam(value = "redistrictNumber") int redistrictNumber) {
        JSONObject jsonObject = districtService.getDistrictingPlan(redistrictNumber);
        return jsonObject;
    }

    @GetMapping("/districting/districtPlanStatistics")
    public DistrictingPlanStatistics getDistrictPlanStatistics() {
        return districtService.getDistrictingPlanStatistics();
    }

    @GetMapping("/reset")
    public void resetState() {
        districtService.resetState();
    }

    @GetMapping("/getBoxAndWhisker")
    public JSONObject getBoxAndWhisker(@RequestParam(value = "basis") int basis) {
        return districtService.getBoxAndWhisker(Basis.values()[basis]);
    }

    @PostMapping("/setPopulationMeasure")
    public void setPopulationMeasure(@RequestParam(value = "populationMeasure") int populationMeasure) {
        districtService.setPopulationMeasure(PopulationMeasure.values()[populationMeasure]);
    }
}
