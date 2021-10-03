package MothBalls.Randistrictr;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@CrossOrigin("*")
@RequestMapping("randistrictr")
@RestController
public class RedistrictingController {

    @GetMapping("/redistricting")
    public JSONObject getRedistricting(@RequestParam(value = "stateName", defaultValue = "Maryland") String stateName,
                                       @RequestParam(value = "redistrictNumber", defaultValue = "1") String redistrictNumber) {
        return parseGEOJSON(stateName);
    }

    @GetMapping("/run-algorithm")
    public JSONObject returnStateJson(@RequestParam(value = "stateName", defaultValue = "Maryland") String stateName,
                                  @RequestParam(value = "minOpportunity", defaultValue = "2") String minOpportunity,
                                  @RequestParam(value = "maxOpportunity", defaultValue = "6") String maxOpportunity,
                                  @RequestParam(value = "minThreshold", defaultValue = "0.5") String minThreshold,
                                  @RequestParam(value = "maxDiff", defaultValue = "0.07") String maxDiff,
                                  @RequestParam(value = "maxEffGap", defaultValue = "0.9") String maxEffGap,
                                  @RequestParam(value = "minPolsbyPopper", defaultValue = "0.5") String minPolsbyPopper,
                                  @RequestParam(value = "numIterations", defaultValue = "100") String iterations) {

        return parseGEOJSON(stateName);
    }

    public JSONObject parseGEOJSON(String stateName) {
        Object obj = new Object();
        JSONParser parser = new JSONParser();
        Set<String> states = new HashSet<>(Arrays.asList("maryland", "michigan", "utah"));
        try {
            if (states.contains(stateName.toLowerCase())) {
               obj = parser.parse(new FileReader("src/main/java/MothBalls/Randistrictr/constants/" + stateName.toLowerCase() + "_congressional_districts.json"));
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
