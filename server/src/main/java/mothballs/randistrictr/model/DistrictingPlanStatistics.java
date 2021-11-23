package mothballs.randistrictr.model;

import javax.persistence.*;

@Entity
public class DistrictingPlanStatistics {

    @Id
    private String id;

    private String state;
    private int redistrictNumber;
    private String description;
    private int numOpportunityDistricts;
    private double absoluteDifferenceInPopulation;
    private double efficiencyGap;
    private double populationScore;
    private double objectiveFunctionScore;

    private int numCongressionalDistricts;

    public DistrictingPlanStatistics(){}

    public DistrictingPlanStatistics(String state, int redistrictNumber, String description, int numOpportunityDistricts,
                                     double absoluteDifferenceInPopulation, double efficiencyGap, double populationScore,
                                     double objectiveFunctionScore, int numCongressionalDistricts) {
        this.state = state;
        this.redistrictNumber = redistrictNumber;
        this.description = description;
        this.numOpportunityDistricts = numOpportunityDistricts;
        this.absoluteDifferenceInPopulation = absoluteDifferenceInPopulation;
        this.efficiencyGap = efficiencyGap;
        this.populationScore = populationScore;
        this.objectiveFunctionScore = objectiveFunctionScore;
        this.numCongressionalDistricts = numCongressionalDistricts;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getRedistrictNumber() {
        return redistrictNumber;
    }

    public void setRedistrictNumber(int redistrictNumber) {
        this.redistrictNumber = redistrictNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumOpportunityDistricts() {
        return numOpportunityDistricts;
    }

    public void setNumOpportunityDistricts(int numOpportunityDistricts) {
        this.numOpportunityDistricts = numOpportunityDistricts;
    }

    public double getAbsoluteDifferenceInPopulation() {
        return absoluteDifferenceInPopulation;
    }

    public void setAbsoluteDifferenceInPopulation(double absoluteDifferenceInPopulation) {
        this.absoluteDifferenceInPopulation = absoluteDifferenceInPopulation;
    }

    public double getEfficiencyGap() {
        return efficiencyGap;
    }

    public void setEfficiencyGap(double efficiencyGap) {
        this.efficiencyGap = efficiencyGap;
    }

    public double getPopulationScore() {
        return populationScore;
    }

    public void setPopulationScore(double populationScore) {
        this.populationScore = populationScore;
    }

    public double getObjectiveFunctionScore() {
        return objectiveFunctionScore;
    }

    public void setObjectiveFunctionScore(double objectiveFunctionScore) {
        this.objectiveFunctionScore = objectiveFunctionScore;
    }

    public int getNumCongressionalDistricts() {
        return numCongressionalDistricts;
    }

    public void setNumCongressionalDistricts(int numCongressionalDistricts) {
        this.numCongressionalDistricts = numCongressionalDistricts;
    }

    @Transient
    public DistrictingPlanStatistics deepClone() {
        return new DistrictingPlanStatistics(state, redistrictNumber, description, numOpportunityDistricts,
                absoluteDifferenceInPopulation, efficiencyGap, populationScore, objectiveFunctionScore, numCongressionalDistricts);

    }
}
