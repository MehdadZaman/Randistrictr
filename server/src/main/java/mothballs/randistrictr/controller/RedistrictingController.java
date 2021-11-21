package mothballs.randistrictr.controller;

import mothballs.randistrictr.model.Population;
import mothballs.randistrictr.service.DistrictService;
import mothballs.randistrictr.service.DistrictingService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.FileReader;
import java.util.*;

@CrossOrigin("*")
@RequestMapping("randistrictr")
@RestController
public class RedistrictingController {
    @Autowired
    DistrictService districtService;

    @Autowired
    DistrictingService districtingPlanService;

    @GetMapping("/redistricting")
    public JSONObject getRedistricting(@RequestParam(value = "stateName") String stateName,
                                       @RequestParam(value = "redistrictNumber") String redistrictNumber) {
//        districtService.testDistrict();
        districtingPlanService.addDistrictingPlan();
        return parseGeoJSON(stateName);
    }

    @GetMapping("/run-algorithm")
    public JSONObject returnStateJson(@RequestParam(value = "stateName") String stateName,
                                  @RequestParam(value = "minOpportunity") String minOpportunity,
                                  @RequestParam(value = "maxOpportunity") String maxOpportunity,
                                  @RequestParam(value = "minThreshold") String minThreshold,
                                  @RequestParam(value = "maxDiff") String maxDiff,
                                  @RequestParam(value = "maxEffGap") String maxEffGap,
                                  @RequestParam(value = "minPolsbyPopper") String minPolsbyPopper,
                                  @RequestParam(value = "numIterations") String iterations) {
        // TODO: Use parameters in algorithm and return appropriate geoJSON
        return parseGeoJSON(stateName);
    }

    @GetMapping("/popID")
    public Population getPopulationJson(@RequestParam(value = "popID") String popID) {
        // TODO: Use parameters in algorithm and return appropriate geoJSON
        // System.out.println(districtService.getPopulation(popID));
        return districtService.getPopulation(popID);
    }

    @GetMapping("/allPops")
    public List<Population> getAllPops() {
        // TODO: Use parameters in algorithm and return appropriate geoJSON
//        // System.out.println(districtService.getPopulation(popID));
//        List<Population> lst = districtService.getAllPopulations();
//        List<Population> ret = new ArrayList<>();
//        for(int i = 0; i < 100; i++) {
//            ret.add(lst.get(i));
//        }
//        return ret;
        return null;
    }

    @GetMapping

    public JSONObject parseGeoJSON(String stateName) {
        Object obj;
        JSONParser parser = new JSONParser();
        Set<String> states = new HashSet<>(Arrays.asList("maryland", "michigan", "utah"));
        try {
            if (states.contains(stateName.toLowerCase())) {
               obj = parser.parse(new FileReader("src/main/java/mothballs/randistrictr/constants/" + stateName.toLowerCase() + "_congressional_districts.json"));
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The state selected is not one of the three available states");
            }
            return (JSONObject) obj;
        }
        catch(ResponseStatusException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The state selected is not one of the three available states");
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error parsing Geojson file", e);
        }
    }
}
