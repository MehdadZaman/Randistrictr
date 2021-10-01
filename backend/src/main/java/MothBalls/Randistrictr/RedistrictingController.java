package MothBalls.Randistrictr;

import MothBalls.Randistrictr.Person;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;


@RequestMapping("api")
@RestController
public class RedistrictingController {
    @GetMapping("/redistricting")
    public JSONObject getRedistricting(@RequestParam String stateName, @RequestParam String redistrictNumber) {
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
                case "MD":
                    obj = parser.parse(new FileReader("src/main/java/MothBalls/Randistrictr/constants/maryland_congressional_districts.json"));
                    break;
                case "MI":
                    obj = parser.parse(new FileReader("src/main/java/MothBalls/Randistrictr/constants/michigan_congressional_districts.json"));
                    break;
                case "UT":
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
