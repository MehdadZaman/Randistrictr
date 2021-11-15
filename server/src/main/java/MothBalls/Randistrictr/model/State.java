package MothBalls.Randistrictr.model;

import java.util.List;

public class State {

    List<DistrictingPlan> districtingPlanList;
    Population population;
    int numDistricts;
    DistrictingPlan enactedDistricting;
    String name;
    // PopulationTye


    public State(List<DistrictingPlan> districtingPlanList, Population population,
                 int numDistricts, DistrictingPlan enactedDistricting, String name) {
        this.districtingPlanList = districtingPlanList;
        this.population = population;
        this.numDistricts = numDistricts;
        this.enactedDistricting = enactedDistricting;
        this.name = name;
    }

    public void addDistricting(DistrictingPlan districtingPlan) {
        districtingPlanList.add(districtingPlan);
    }

    public List<DistrictingPlan> getAllDistrictingPlans() {
        return districtingPlanList;
    }

    public Population getStatePopulationInformation() {
        return population;
    }

    public int getNumDistricts() {
        return numDistricts;
    }

    public DistrictingPlan getDistrictingPlan() {
        return enactedDistricting;
    }

    public String getName() {
        return name;
    }

}
