package mothballs.randistrictr.service;

import mothballs.randistrictr.model.*;
import mothballs.randistrictr.repository.*;
import org.hibernate.Hibernate;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class DistrictService {
    final String ENACTED_DISTRICTING_PLAN = "00";

    @Autowired
    DistrictRepository districtRepository;

    @Autowired
    PopulationRepository populationRepository;

    @Autowired
    StateRepository stateRepository;

    @Autowired
    CensusBlockRepository censusBlockRepository;

    @Autowired
    CensusBlockService censusBlockService;

    @Autowired
    DistrictingPlanStatisticsRepository districtingPlanStatisticsRepository;

    private State currentState;
    private DistrictingPlan currentDistrictingPlan;
    // private DistrictingPlan enactedDistrictingPlan;

    public Population getPopulation(String id) {
        return populationRepository.findByGeoID20(id);
    }

    public void selectState(String state) {
        this.currentState = stateRepository.findStateByState(state);
        Hibernate.initialize(this.currentState.getDistrictingPlans());
        // this.enactedDistrictingPlan = this.currentState.getDistrictingPlans().get(ENACTED_DISTRICTING_PLAN);
    }

    public JSONObject getEnactedDistricting() {
        return readEnactedDistrictingPlan(currentState.getState());
    }

    public List<DistrictingPlanStatistics> getAllDistrictingPlanStatistics() {
        List<DistrictingPlanStatistics> districtingPlanStatistics = new ArrayList<>();
        for(DistrictingPlan districtingPlan : currentState.getDistrictingPlans()) {
            districtingPlanStatistics.add(districtingPlan.getDistrictingPlanStatistics());
        }
        return districtingPlanStatistics;
    }

    public JSONObject getDistrictingPlan(int districtPlanNumber) {
        this.currentDistrictingPlan = stateRepository.findStateByState(this.currentState.getState()).getDistrictingPlans().get(districtPlanNumber);
//        this.currentDistrictingPlan = this.currentState.getDistrictingPlans().get(districtPlanNumber);
        return censusBlockService.getDistrictingJSON(this.currentDistrictingPlan);
    }

    public DistrictingPlanStatistics getDistrictingPlanStatistics() {
        return currentDistrictingPlan.getDistrictingPlanStatistics();
    }

    public DistrictingPlanStatistics getEnactedDistrictingPlanStatistics() {
        //return enactedDistrictingPlan.getDistrictingPlanStatistics();
        return districtingPlanStatisticsRepository.findById(currentState.getStateNumber() + ENACTED_DISTRICTING_PLAN);
    }

    public DistrictingPlan getCurrentDistrictingPlan() {
        return currentDistrictingPlan;
    }

    public void setCurrentDistrictingPlan(DistrictingPlan currentDistrictingPlan) {
        this.currentDistrictingPlan = currentDistrictingPlan;
    }


    public JSONObject readEnactedDistrictingPlan(String stateName) {
        try {
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader("src/main/java/mothballs/randistrictr/constants/" + stateName.toLowerCase() + "_congressional_districts.json");
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
