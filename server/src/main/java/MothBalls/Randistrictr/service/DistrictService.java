package MothBalls.Randistrictr.service;

import MothBalls.Randistrictr.model.*;
import MothBalls.Randistrictr.repository.CensusBlockRepository;
import MothBalls.Randistrictr.repository.DistrictRepository;
import MothBalls.Randistrictr.repository.PopulationRepository;
import MothBalls.Randistrictr.repository.StateRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
