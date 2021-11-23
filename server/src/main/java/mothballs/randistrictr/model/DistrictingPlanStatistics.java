package mothballs.randistrictr.model;

import javax.persistence.*;

@Entity
public class DistrictingPlanStatistics {

    @Id
    private String id;

    private String state;
    private int redistrictNumber;
    // private Population population;
    private String description;
    // private String previewImage;
    private int numOpportunityDistricts;
    private double absoluteDifferenceInPopulation;
    private double efficiencyGap;
    private double populationScore;
    private double objectiveFunctionScore;

    private int numCongressionalDistricts;

//    public DistrictingPlanStatistics(){
//
//    }
//    public DistrictingPlanStatistics(int redistrictNumber, Population population, String description, String previewImage,
//                                     int numOpportunities, double threshold, double absoluteDifferenceInPopulation,
//                                     double efficiencyGap, double polsbyPopperScore, double objectiveFunctionMeasure) {
//        this.redistrictNumber = redistrictNumber;
//        this.population = population;
//        this.description = description;
//        this.previewImage = previewImage;
//        this.numOpportunities = numOpportunities;
//        this.threshold = threshold;
//        this.absoluteDifferenceInPopulation = absoluteDifferenceInPopulation;
//        this.efficiencyGap = efficiencyGap;
//        this.polsbyPopperScore = polsbyPopperScore;
//        this.objectiveFunctionMeasure = objectiveFunctionMeasure;
//    }


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
}
