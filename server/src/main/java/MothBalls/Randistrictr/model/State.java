package mothballs.randistrictr.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class State implements Serializable {

    @Id
    String state;
    String stateNumber;

    @OneToMany
    @JoinColumns({
            @JoinColumn(name="state", referencedColumnName="stateNumber")
    })
    List<DistrictingPlan> districtingPlans;

    @OneToOne
    @PrimaryKeyJoinColumn
    Population population;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateNumber() {
        return stateNumber;
    }

    public void setStateNumber(String stateNumber) {
        this.stateNumber = stateNumber;
    }

    public List<DistrictingPlan> getDistrictingPlans() {
        return districtingPlans;
    }

    public void setDistrictingPlans(List<DistrictingPlan> districtingPlans) {
        this.districtingPlans = districtingPlans;
    }

    public Population getPopulation() {
        return population;
    }

    public void setPopulation(Population population) {
        this.population = population;
    }

    //    DistrictingPlan enactedDistricting;

//    public State(List<DistrictingPlan> districtingPlanList, Population population,
//                 int numDistricts, DistrictingPlan enactedDistricting, String name) {
//        this.districtingPlanList = districtingPlanList;
//        this.population = population;
//        this.numDistricts = numDistricts;
//        this.enactedDistricting = enactedDistricting;
//        this.name = name;
//    }
}
