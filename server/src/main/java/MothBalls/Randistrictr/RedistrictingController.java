package MothBalls.Randistrictr;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;

@CrossOrigin("*")
@RequestMapping("api")
@RestController
public class RedistrictingController {

    @GetMapping("/redistricting")
    public JSONObject getRedistricting(@RequestParam String stateName, @RequestParam String redistrictNumber) {
        return parseGEOJSON(stateName);
    }

    @GetMapping("/run-algorithm")
    public JSONObject returnStateJson(@RequestParam(value = "stateName", defaultValue = "maryland") String stateName,
                                  @RequestParam(value = "minOpportunity", defaultValue = "2") String minOpportunity,
                                  @RequestParam(value = "maxOpportunity", defaultValue = "6") String maxOpportunity,
                                  @RequestParam(value = "minThreshold", defaultValue = "0.5") String minThreshold,
                                  @RequestParam(value = "maxDiff", defaultValue = "0.07") String maxDiff,
                                  @RequestParam(value = "maxEffGap", defaultValue = "0.9") String maxEffGap,
                                  @RequestParam(value = "minPolsbyPopper", defaultValue = "0.5") String minPolsbyPopper,
                                  @RequestParam(value = "numIterations", defaultValue = "100") String iterations) {

        return parseGEOJSON(stateName);
    }

    //Statenames are acronyms
    // i.e. MD == Maryland, MI = Michigan, UT = Utah
    // take the content root when getting path
    public JSONObject parseGEOJSON(String stateName) {
        Object obj = new Object();
        JSONParser parser = new JSONParser();
        try {
            switch (stateName) {
                case "Maryland":
                    obj = parser.parse(new FileReader("src/main/java/MothBalls/Randistrictr/constants/maryland_congressional_districts.json"));
                    break;
                case "Michigan":
                    obj = parser.parse(new FileReader("src/main/java/MothBalls/Randistrictr/constants/michigan_congressional_districts.json"));
                    break;
                case "Utah":
                    obj = parser.parse(new FileReader("src/main/java/MothBalls/Randistrictr/constants/utah_congressional_districts.json"));
                    break;
            }
            return (JSONObject) obj;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
