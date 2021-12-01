package mothballs.randistrictr.model;

import javax.persistence.*;

@Entity
public class DistrictingPlanStatistics {

    @Id
    private String id;
    private String state;
    private int redistrictNumber;
    private String description;

    private double totalEfficiencyGap;
    private double totalPopulationScore;
    private double totalObjectiveFunctionScore;

    private double cvapEfficiencyGap;
    private double cvapPopulationScore;
    private double cvapObjectiveFunctionScore;

    private double vapEfficiencyGap;
    private double vapPopulationScore;
    private double vapObjectiveFunctionScore;

    private int numCongressionalDistricts;

    private int numRepublicanCongressionalDistricts;
    private int numDemocraticCongressionalDistricts;

    public DistrictingPlanStatistics(){}

    public DistrictingPlanStatistics(String id, String state, int redistrictNumber, String description,
                                     double totalEfficiencyGap, double totalPopulationScore,
                                     double totalObjectiveFunctionScore, double cvapEfficiencyGap,
                                     double cvapPopulationScore, double cvapObjectiveFunctionScore,
                                     double vapEfficiencyGap, double vapPopulationScore, double vapObjectiveFunctionScore,
                                     int numCongressionalDistricts, int numRepublicanCongressionalDistricts,
                                     int numDemocraticCongressionalDistricts) {
        this.id = id;
        this.state = state;
        this.redistrictNumber = redistrictNumber;
        this.description = description;
        this.totalEfficiencyGap = totalEfficiencyGap;
        this.totalPopulationScore = totalPopulationScore;
        this.totalObjectiveFunctionScore = totalObjectiveFunctionScore;
        this.cvapEfficiencyGap = cvapEfficiencyGap;
        this.cvapPopulationScore = cvapPopulationScore;
        this.cvapObjectiveFunctionScore = cvapObjectiveFunctionScore;
        this.vapEfficiencyGap = vapEfficiencyGap;
        this.vapPopulationScore = vapPopulationScore;
        this.vapObjectiveFunctionScore = vapObjectiveFunctionScore;
        this.numCongressionalDistricts = numCongressionalDistricts;
        this.numRepublicanCongressionalDistricts = numRepublicanCongressionalDistricts;
        this.numDemocraticCongressionalDistricts = numDemocraticCongressionalDistricts;
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
        return new DistrictingPlanStatistics(id, state, redistrictNumber, description, totalEfficiencyGap,
                totalPopulationScore, totalObjectiveFunctionScore, cvapEfficiencyGap, cvapPopulationScore,
                cvapObjectiveFunctionScore, vapEfficiencyGap, vapPopulationScore, vapObjectiveFunctionScore,
                numCongressionalDistricts, numRepublicanCongressionalDistricts, numDemocraticCongressionalDistricts);
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