package MothBalls.Randistrictr.service;

import MothBalls.Randistrictr.model.*;
import MothBalls.Randistrictr.repository.DistrictRepository;
import MothBalls.Randistrictr.repository.PopulationRepository;
import MothBalls.Randistrictr.repository.StateRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class DistrictService {
    final int ENACTED_DISTRICTING_PLAN = 0;

    @Autowired
    DistrictRepository districtRepository;

    @Autowired
    PopulationRepository populationRepository;

    @Autowired
    StateRepository stateRepository;

    private State currentState;
    private DistrictingPlan currentDistrictingPlan;
    private DistrictingPlan enactedDistrictingPlan;

    public Population getPopulation(String id) {
        return populationRepository.findByGeoID20(id);
    }

    public void selectState(String state) {
        this.currentState = stateRepository.findStateByState(state);
        this.enactedDistrictingPlan = this.currentState.getDistrictingPlans().get(ENACTED_DISTRICTING_PLAN);
    }

    public void testDistrict() {
       District district = districtRepository.getById((long)1);
       // System.out.println(district.getId());
    }

    public JSONObject getEnactedDistricting() {
        return this.getDistrictingJSON(this.enactedDistrictingPlan);
    }

    public JSONObject getDistrictingJSON(DistrictingPlan districtingPlan) {
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

        return jsonObject;
    }
}
