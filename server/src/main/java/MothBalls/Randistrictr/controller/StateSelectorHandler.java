package MothBalls.Randistrictr.controller;

import MothBalls.Randistrictr.model.*;

import java.util.ArrayList;
import java.util.List;

public class StateSelectorHandler {

    private List<State> states;
    private State currentState;
    private DistrictingPlan currentDistrictingPlan;

    public StateSelectorHandler(List<State> states) {
        this.states = states;
    }

    public List<DistrictingPlan> getFilteredDistricts(ClientFilterParameters clientFilterParameters) {
        setCurrentState(clientFilterParameters.getState());
//        List<DistrictingPlan> districtingPlanList = currentState.getAllDistrictingPlans();
        List<DistrictingPlan> filteredDistrictingPlans = new ArrayList<>();
//        for (DistrictingPlan districtingPlan : districtingPlanList) {
//            if (isValid(clientFilterParameters, districtingPlan)) {
//                filteredDistrictingPlans.add(districtingPlan);
//            }
//
//        }
        return filteredDistrictingPlans;
    }

    private boolean isValid(ClientFilterParameters clientFilterParameters, DistrictingPlan districtingPlan) {
        // List<District> districts = districtingPlan.getDistricts();
//        int opportunityDistricts = 0;
//        for (District district : districts) {
////            if (district.isOpportunityDistrict()) {
////                opportunityDistricts++;
////            }
//        }
//        DistrictingPlanStatistics districtingPlanStatistics = districtingPlan.getDistrictingPlanStatistics();
//        return clientFilterParameters.getMinThreshold() <= districtingPlanStatistics.getThreshold()
//                && clientFilterParameters.getMinPopulationScore() <= districtingPlanStatistics.getPopulation().calculatePopulationScore()
//                && clientFilterParameters.getMinMinorityMajorityDistricts() <= opportunityDistricts
//                && clientFilterParameters.getMaxMinorityMajorityDistricts() >= opportunityDistricts;
        return false;
    }


    public List<double[]> getMapFilteredBoundary() {
        return null;
    }

    public List<DistrictingPlan> getSampleDistrictingPlans() {
        if (currentState == null) {
            return null;
        }
//        return currentState.getAllDistrictingPlans();
        return null;
    }

    public DistrictingPlan getSelectedSampleDistricting(String stateName, int districtingPlanNumber) {
        State state = setCurrentState(stateName);
        if (state == null) {
            return null;
        }
//        return state.getAllDistrictingPlans().get(districtingPlanNumber);
        return null;
    }

    public DistrictingPlan getAverageDistricting(State state) {
        return null;
    }

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }

    public State getCurrentState() {
        return currentState;
    }

    public State setCurrentState(String stateName) {
//        for (State state : states) {
//            if (state.getName().equals(stateName)) {
//                currentState = state;
//                return currentState;
//            }
//        }
        return null;
    }

    public DistrictingPlan getCurrentDistrictingPlan() {
        return currentDistrictingPlan;
    }

    public void setCurrentDistrictingPlan(DistrictingPlan currentDistrictingPlan) {
        this.currentDistrictingPlan = currentDistrictingPlan;
    }

//    public DistrictingPlanStatistics updateAlgoProgressDisplay() {
//        return currentDistrictingPlan.getDistrictingPlanStatistics();
//    }

//    public Population getStatePopulationInformation() {
//        return currentState.getStatePopulationInformation();
//    }
//
//    public List<DistrictingPlan> getAllStateDistrictings() {
//        return currentState.getAllDistrictingPlans();
//    }

}
