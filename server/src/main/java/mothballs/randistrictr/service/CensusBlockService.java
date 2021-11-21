package mothballs.randistrictr.service;

import mothballs.randistrictr.model.CensusBlock;
import mothballs.randistrictr.model.District;
import mothballs.randistrictr.model.DistrictingPlan;
import mothballs.randistrictr.model.Population;
import mothballs.randistrictr.object.Geometry;
import mothballs.randistrictr.object.Polygon;
import mothballs.randistrictr.repository.CensusBlockRepository;
import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;

@Service
public class CensusBlockService {

    @Autowired
    CensusBlockRepository censusBlockRepository;



    public void voodooGeometry(){
    }
    
    public static Geometry stringToGeometry(String geoString) {
        Gson gson = new Gson();
        Polygon polygon = gson.fromJson(geoString, Polygon.class);
        Geometry geometry = new Geometry("Polygon", polygon.coordinates);
        return geometry;
    }

    public static String geometryToString(Geometry geo) {
        Gson gson = new Gson();
        return gson.toJson(geo);
    }

    public JSONObject getDistrictingJSON(DistrictingPlan districtingPlan) {
        writeDistrictingJSON(districtingPlan);
        // dissolveCensusBlocks();

//        JSONParser jsonParser = new JSONParser();
//        try {
//            FileReader reader = new FileReader("employees.json");
//            Object obj = jsonParser.parse(reader);
//
//            JSONArray employeeList = (JSONArray) obj;
//            System.out.println(employeeList);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return null;
    }

    public JSONObject writeDistrictingJSON(DistrictingPlan districtingPlan) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type", "FeatureCollection");

        JSONArray censusBlockArray = new JSONArray();

        List<District> districts = districtingPlan.getDistricts();

        for(District district : districts) {

            Set<CensusBlock> censusBlocks = district.getCensusBlocks();

            for(CensusBlock cB : censusBlocks) {
                Population censusBlockPopulation = cB.getPopulation();

                JSONObject cBJSON = new JSONObject();
                cBJSON.put("type", "Feature");

                JSONObject properties = new JSONObject();

                properties.put("GEOID20", cB.getGeoID20());
                properties.put("STATE", cB.getState());
                properties.put("CD", cB.getCongressionalDistrict());
                properties.put("DISTRICT_PLAN", cB.getDistrictingPlan());
                properties.put("PRECINCT_ID", cB.getPrecinctID());

                properties.put("TOTAL_TOTAL", censusBlockPopulation.getTotalTotalPopulation());
                properties.put("TOTAL_WHITE", censusBlockPopulation.getTotalWhitePopulation());
                properties.put("TOTAL_BLACK", censusBlockPopulation.getTotalBlackPopulation());
                properties.put("TOTAL_HISPANIC", censusBlockPopulation.getTotalHispanicPopulation());
                properties.put("TOTAL_AMERICANINDIAN", censusBlockPopulation.getTotalAmericanIndianPopulation());
                properties.put("TOTAL_ASIAN", censusBlockPopulation.getTotalAsianPopulation());
                properties.put("TOTAL_HAWAIIAN", censusBlockPopulation.getTotalHawaiianPopulation());
                properties.put("TOTAL_OTHER", censusBlockPopulation.getTotalOtherPopulation());

                properties.put("VAP_TOTAL", censusBlockPopulation.getVapTotalPopulation());
                properties.put("VAP_WHITE", censusBlockPopulation.getVapWhitePopulation());
                properties.put("VAP_BLACK", censusBlockPopulation.getVapBlackPopulation());
                properties.put("VAP_HISPANIC", censusBlockPopulation.getVapHispanicPopulation());
                properties.put("VAP_AMERICANINDIAN", censusBlockPopulation.getVapAmericanIndianPopulation());
                properties.put("VAP_ASIAN", censusBlockPopulation.getVapAsianPopulation());
                properties.put("VAP_HAWAIIAN", censusBlockPopulation.getVapHawaiianPopulation());
                properties.put("VAP_OTHER", censusBlockPopulation.getVapOtherPopulation());

                properties.put("CVAP_TOTAL", censusBlockPopulation.getCvapTotalPopulation());
                properties.put("CVAP_WHITE", censusBlockPopulation.getCvapWhitePopulation());
                properties.put("CVAP_BLACK", censusBlockPopulation.getCvapBlackPopulation());
                properties.put("CVAP_HISPANIC", censusBlockPopulation.getCvapHispanicPopulation());
                properties.put("CVAP_AMERICANINDIAN", censusBlockPopulation.getCvapAmericanIndianPopulation());
                properties.put("CVAP_ASIAN", censusBlockPopulation.getCvapAsianPopulation());
                properties.put("CVAP_HAWAIIAN", censusBlockPopulation.getCvapHawaiianPopulation());
                properties.put("CVAP_OTHER", censusBlockPopulation.getCvapOtherPopulation());

                properties.put("DEMOCRAT", 0);
                properties.put("REPUBLICAN", 0);
                properties.put("OTHER", 0);

                cBJSON.put("properties", properties);

                JSONObject geometry = new JSONObject();
                geometry.put("type", cB.getGeometryType());
                geometry.put("coordinates", cB.getGeometry());

                cBJSON.put("geometry", geometry);

                censusBlockArray.add(cBJSON);
            }
        }

        jsonObject.put("features", censusBlockArray);

//        try {
//            FileWriter file = new FileWriter("preprocessedPrecincts.json");
//            file.write(jsonObject.toJSONString());
//            file.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return jsonObject;
    }

    public void dissolveCensusBlocks() {
        Runtime r = Runtime.getRuntime();
        String[] commands = {"cmd.exe", "/c", "mapshaper -i preprocessedPrecincts.json -dissolve CD -o output.json"};

        try {
            Process p = r.exec(commands);
            p.waitFor();
            BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";
            while((line = b.readLine()) != null) {
                System.out.println(line);
            }
            b.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
