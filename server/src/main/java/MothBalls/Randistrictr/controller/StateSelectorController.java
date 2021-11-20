package MothBalls.Randistrictr.controller;

import MothBalls.Randistrictr.model.Population;
import MothBalls.Randistrictr.model.State;
import MothBalls.Randistrictr.service.DistrictService;
import MothBalls.Randistrictr.service.DistrictingService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.FileReader;
import java.util.*;

@CrossOrigin("*")
@RequestMapping("randistrictr/select")
@RestController
public class StateSelectorController {
    @Autowired
    DistrictService districtService;

    @GetMapping("/state/population")
    public Population getStatePopulation(@RequestParam(value = "stateName") String stateName) {
        // TODO: Use parameters in algorithm and return appropriate geoJSON
        System.out.println("PINGED");
        districtService.selectState(stateName);
        Population statePopulation = districtService.getPopulation(stateName);
        System.out.println("DONE");
        return statePopulation;
    }

    @GetMapping("/state/enactedDistricting")
    public JSONObject getEnactedDistricting() {
        // TODO: Use parameters in algorithm and return appropriate geoJSON
        System.out.println("PINGED");
        JSONObject jsonObject = districtService.getEnactedDistricting();
        System.out.println(jsonObject.toJSONString());
        System.out.println("DONE");
        return null;
    }

    @GetMapping("/state/districting")
    public String getStateRedistricting(@RequestParam(value = "stateName") String stateName,
                                           @RequestParam(value = "redistrictNumber") int redistrictNumber) {
        // TODO: Use parameters in algorithm and return appropriate geoJSON
//        System.out.println("PINGED");
//        State state = districtService.getDistricting(stateName, redistrictNumber);
//        System.out.println(state.getStateNumber());
//        System.out.println((state.getDistrictingPlans().get(0)).getDistricts());
//        System.out.println("DONE");
        return null;
    }
}
