package mothballs.randistrictr.model;

import javax.persistence.*;

@Entity
public class DistrictingPlanStatistics {

    @Id
    private String id;
    private String state;
    private int redistrictNumber;
    private String description;
    private int totalNumOpportunityDistricts;
    private double totalAbsoluteDifferenceInPopulation;
    private double totalEfficiencyGap;
    private double totalPopulationScore;
    private double totalObjectiveFunctionScore;
    private int cvapNumOpportunityDistricts;
    private double cvapAbsoluteDifferenceInPopulation;
    private double cvapEfficiencyGap;
    private double cvapPopulationScore;
    private double cvapObjectiveFunctionScore;
    private int vapNumOpportunityDistricts;
    private double vapAbsoluteDifferenceInPopulation;
    private double vapEfficiencyGap;
    private double vapPopulationScore;
    private double vapObjectiveFunctionScore;
    private int numCongressionalDistricts;

    public DistrictingPlanStatistics(){}

    public DistrictingPlanStatistics(String id, String state, int redistrictNumber, String description,
                                     int totalNumOpportunityDistricts, double totalAbsoluteDifferenceInPopulation,
                                     double totalEfficiencyGap, double totalPopulationScore, double totalObjectiveFunctionScore,
                                     int cvapNumOpportunityDistricts, double cvapAbsoluteDifferenceInPopulation, double cvapEfficiencyGap,
                                     double cvapPopulationScore, double cvapObjectiveFunctionScore, int vapNumOpportunityDistricts,
                                     double vapAbsoluteDifferenceInPopulation, double vapEfficiencyGap, double vapPopulationScore,
                                     double vapObjectiveFunctionScore, int numCongressionalDistricts) {
        this.id = id;
        this.state = state;
        this.redistrictNumber = redistrictNumber;
        this.description = description;
        this.totalNumOpportunityDistricts = totalNumOpportunityDistricts;
        this.totalAbsoluteDifferenceInPopulation = totalAbsoluteDifferenceInPopulation;
        this.totalEfficiencyGap = totalEfficiencyGap;
        this.totalPopulationScore = totalPopulationScore;
        this.totalObjectiveFunctionScore = totalObjectiveFunctionScore;
        this.cvapNumOpportunityDistricts = cvapNumOpportunityDistricts;
        this.cvapAbsoluteDifferenceInPopulation = cvapAbsoluteDifferenceInPopulation;
        this.cvapEfficiencyGap = cvapEfficiencyGap;
        this.cvapPopulationScore = cvapPopulationScore;
        this.cvapObjectiveFunctionScore = cvapObjectiveFunctionScore;
        this.vapNumOpportunityDistricts = vapNumOpportunityDistricts;
        this.vapAbsoluteDifferenceInPopulation = vapAbsoluteDifferenceInPopulation;
        this.vapEfficiencyGap = vapEfficiencyGap;
        this.vapPopulationScore = vapPopulationScore;
        this.vapObjectiveFunctionScore = vapObjectiveFunctionScore;
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


    public int getNumCongressionalDistricts() {
        return numCongressionalDistricts;
    }

    public void setNumCongressionalDistricts(int numCongressionalDistricts) {
        this.numCongressionalDistricts = numCongressionalDistricts;
    }

    public DistrictingPlanStatistics deepClone() {
        return new DistrictingPlanStatistics(id, state, redistrictNumber, description, totalNumOpportunityDistricts, totalAbsoluteDifferenceInPopulation,
        totalEfficiencyGap, totalPopulationScore, totalObjectiveFunctionScore, cvapNumOpportunityDistricts, cvapAbsoluteDifferenceInPopulation, cvapEfficiencyGap,
        cvapPopulationScore, cvapObjectiveFunctionScore, vapNumOpportunityDistricts, vapAbsoluteDifferenceInPopulation, vapEfficiencyGap, vapPopulationScore,
        vapObjectiveFunctionScore, numCongressionalDistricts);
    }

    public int getTotalNumOpportunityDistricts() {
        return totalNumOpportunityDistricts;
    }

    public void setTotalNumOpportunityDistricts(int totalNumOpportunityDistricts) {
        this.totalNumOpportunityDistricts = totalNumOpportunityDistricts;
    }

    public double getTotalAbsoluteDifferenceInPopulation() {
        return totalAbsoluteDifferenceInPopulation;
    }

    public void setTotalAbsoluteDifferenceInPopulation(double totalAbsoluteDifferenceInPopulation) {
        this.totalAbsoluteDifferenceInPopulation = totalAbsoluteDifferenceInPopulation;
    }

    public double getTotalEfficiencyGap() {
        return totalEfficiencyGap;
    }

    public void setTotalEfficiencyGap(double totalEfficiencyGap) {
        this.totalEfficiencyGap = totalEfficiencyGap;
    }

    public double getTotalPopulationScore() {
        return totalPopulationScore;
    }

    public void setTotalPopulationScore(double totalPopulationScore) {
        this.totalPopulationScore = totalPopulationScore;
    }

    public double getTotalObjectiveFunctionScore() {
        return totalObjectiveFunctionScore;
    }

    public void setTotalObjectiveFunctionScore(double totalObjectiveFunctionScore) {
        this.totalObjectiveFunctionScore = totalObjectiveFunctionScore;
    }

    public int getCvapNumOpportunityDistricts() {
        return cvapNumOpportunityDistricts;
    }

    public void setCvapNumOpportunityDistricts(int cvapNumOpportunityDistricts) {
        this.cvapNumOpportunityDistricts = cvapNumOpportunityDistricts;
    }

    public double getCvapAbsoluteDifferenceInPopulation() {
        return cvapAbsoluteDifferenceInPopulation;
    }

    public void setCvapAbsoluteDifferenceInPopulation(double cvapAbsoluteDifferenceInPopulation) {
        this.cvapAbsoluteDifferenceInPopulation = cvapAbsoluteDifferenceInPopulation;
    }

    public double getCvapEfficiencyGap() {
        return cvapEfficiencyGap;
    }

    public void setCvapEfficiencyGap(double cvapEfficiencyGap) {
        this.cvapEfficiencyGap = cvapEfficiencyGap;
    }

    public double getCvapPopulationScore() {
        return cvapPopulationScore;
    }

    public void setCvapPopulationScore(double cvapPopulationScore) {
        this.cvapPopulationScore = cvapPopulationScore;
    }

    public double getCvapObjectiveFunctionScore() {
        return cvapObjectiveFunctionScore;
    }

    public void setCvapObjectiveFunctionScore(double cvapObjectiveFunctionScore) {
        this.cvapObjectiveFunctionScore = cvapObjectiveFunctionScore;
    }

    public int getVapNumOpportunityDistricts() {
        return vapNumOpportunityDistricts;
    }

    public void setVapNumOpportunityDistricts(int vapNumOpportunityDistricts) {
        this.vapNumOpportunityDistricts = vapNumOpportunityDistricts;
    }

    public double getVapAbsoluteDifferenceInPopulation() {
        return vapAbsoluteDifferenceInPopulation;
    }

    public void setVapAbsoluteDifferenceInPopulation(double vapAbsoluteDifferenceInPopulation) {
        this.vapAbsoluteDifferenceInPopulation = vapAbsoluteDifferenceInPopulation;
    }

    public double getVapEfficiencyGap() {
        return vapEfficiencyGap;
    }

    public void setVapEfficiencyGap(double vapEfficiencyGap) {
        this.vapEfficiencyGap = vapEfficiencyGap;
    }

    public double getVapPopulationScore() {
        return vapPopulationScore;
    }

    public void setVapPopulationScore(double vapPopulationScore) {
        this.vapPopulationScore = vapPopulationScore;
    }

    public double getVapObjectiveFunctionScore() {
        return vapObjectiveFunctionScore;
    }

    public void setVapObjectiveFunctionScore(double vapObjectiveFunctionScore) {
        this.vapObjectiveFunctionScore = vapObjectiveFunctionScore;
    }
}