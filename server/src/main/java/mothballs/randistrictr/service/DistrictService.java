package mothballs.randistrictr.service;

import mothballs.randistrictr.model.*;
import mothballs.randistrictr.repository.CensusBlockRepository;
import mothballs.randistrictr.repository.DistrictRepository;
import mothballs.randistrictr.repository.PopulationRepository;
import mothballs.randistrictr.repository.StateRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistrictService {
    final int ENACTED_DISTRICTING_PLAN = 0;

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

    public JSONObject getEnactedDistricting() {
        return censusBlockService.getDistrictingJSON(this.enactedDistrictingPlan);
    }

    public List<DistrictingPlanStatistics> getAllDistrictingPlanStatistics() {
        List<DistrictingPlanStatistics> districtingPlanStatistics = new ArrayList<>();
        for(DistrictingPlan districtingPlan : currentState.getDistrictingPlans()) {
            districtingPlanStatistics.add(districtingPlan.getDistrictingPlanStatistics());
        }
        return districtingPlanStatistics;
    }

    public JSONObject getDistrictingPlan(int districtPlanNumber) {
        this.currentDistrictingPlan = this.currentState.getDistrictingPlans().get(districtPlanNumber);
        return censusBlockService.getDistrictingJSON(this.currentDistrictingPlan);
    }

    public DistrictingPlanStatistics getDistrictingPlanStatistics() {
        return currentDistrictingPlan.getDistrictingPlanStatistics();
    }

    public DistrictingPlanStatistics getEnactedDistrictingPlanStatistics() {
        return enactedDistrictingPlan.getDistrictingPlanStatistics();
    }
}
