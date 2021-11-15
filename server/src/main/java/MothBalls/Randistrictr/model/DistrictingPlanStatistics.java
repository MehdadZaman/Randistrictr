package MothBalls.Randistrictr.Model;

import javax.persistence.*;

@Entity
public class DistrictingPlanStatistics {

    private int redistrictNumber;
    private Population population;
    private String description;
    private String previewImage;
    private int numOpportunities;
    private double threshold;
    private double absoluteDifferenceInPopulation;
    private double efficiencyGap;
    private double polsbyPopperScore;
    private double objectiveFunctionMeasure;

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

    @Id
    public int getRedistrictNumber() {
        return redistrictNumber;
    }

    public void setRedistrictNumber(int redistrictNumber) {
        this.redistrictNumber = redistrictNumber;
    }

    @OneToOne
    public Population getPopulation() {
        return population;
    }

    public void setPopulation(Population population) {
        this.population = population;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreviewImage() {
        return previewImage;
    }

    public void setPreviewImage(String previewImage) {
        this.previewImage = previewImage;
    }

    public int getNumOpportunities() {
        return numOpportunities;
    }

    public void setNumOpportunities(int numOpportunities) {
        this.numOpportunities = numOpportunities;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
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

    public double getPolsbyPopperScore() {
        return polsbyPopperScore;
    }

    public void setPolsbyPopperScore(double polsbyPopperScore) {
        this.polsbyPopperScore = polsbyPopperScore;
    }

    public double getObjectiveFunctionMeasure() {
        return objectiveFunctionMeasure;
    }

    public void setObjectiveFunctionMeasure(double objectiveFunctionMeasure) {
        this.objectiveFunctionMeasure = objectiveFunctionMeasure;
    }
}
