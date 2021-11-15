package MothBalls.Randistrictr.model;

import javax.persistence.*;
import java.util.Map;

@Entity
public class Population {

    private int numMinority;
    private int totalPopulation;
    private int vaPopulation;
    private int cvaPopulation;
    private int numDemocraticParty;
    private int numRepublicanParty;


    //
    private String geoID20;

    private double totalTotalPopulation;
    private double totalWhitePopulation;
    private double totalBlackPopulation;
    private double totalHispanicPopulation;

    private double totalAmericanIndianPopulation;
    private double totalAsianPopulation;
    private double totalHawaiianPopulation;
    private double totalOtherPopulation;

    private double vAPTotalPopulation;
    private double vAPWhitePopulation;
    private double vAPBlackPopulation;
    private double vAPHispanicPopulation;
    private double vAPAmericanIndianPopulation;
    private double vAPAsianPopulation;
    private double vAPHawaiianPopulation;
    private double vAPOtherPopulation;

    private double cVAPTotalPopulation;
    private double cVAPWhitePopulation;
    private double cVAPBlackPopulation;
    private double cVAPHispanicPopulation;
    private double cVAPAmericanIndianPopulation;
    private double cVAPAsianPopulation;
    private double cVAPHawaiianPopulation;
    private double cVAPOtherPopulation;

    private double democratVoters;
    private double republicanVoters;
    private double otherVoters;
    //

    public String getGeoID20() {
        return geoID20;
    }

    public void setGeoID20(String geoID20) {
        this.geoID20 = geoID20;
    }

    public double getTotalTotalPopulation() {
        return totalTotalPopulation;
    }

    public void setTotalTotalPopulation(double totalTotalPopulation) {
        this.totalTotalPopulation = totalTotalPopulation;
    }

    public double getTotalWhitePopulation() {
        return totalWhitePopulation;
    }

    public void setTotalWhitePopulation(double totalWhitePopulation) {
        this.totalWhitePopulation = totalWhitePopulation;
    }

    public double getTotalBlackPopulation() {
        return totalBlackPopulation;
    }

    public void setTotalBlackPopulation(double totalBlackPopulation) {
        this.totalBlackPopulation = totalBlackPopulation;
    }

    public double getTotalHispanicPopulation() {
        return totalHispanicPopulation;
    }

    public void setTotalHispanicPopulation(double totalHispanicPopulation) {
        this.totalHispanicPopulation = totalHispanicPopulation;
    }

    public double getTotalAmericanIndianPopulation() {
        return totalAmericanIndianPopulation;
    }

    public void setTotalAmericanIndianPopulation(double totalAmericanIndianPopulation) {
        this.totalAmericanIndianPopulation = totalAmericanIndianPopulation;
    }

    public double getTotalAsianPopulation() {
        return totalAsianPopulation;
    }

    public void setTotalAsianPopulation(double totalAsianPopulation) {
        this.totalAsianPopulation = totalAsianPopulation;
    }

    public double getTotalHawaiianPopulation() {
        return totalHawaiianPopulation;
    }

    public void setTotalHawaiianPopulation(double totalHawaiianPopulation) {
        this.totalHawaiianPopulation = totalHawaiianPopulation;
    }

    public double getTotalOtherPopulation() {
        return totalOtherPopulation;
    }

    public void setTotalOtherPopulation(double totalOtherPopulation) {
        this.totalOtherPopulation = totalOtherPopulation;
    }

    public double getvAPTotalPopulation() {
        return vAPTotalPopulation;
    }

    public void setvAPTotalPopulation(double vAPTotalPopulation) {
        this.vAPTotalPopulation = vAPTotalPopulation;
    }

    public double getvAPWhitePopulation() {
        return vAPWhitePopulation;
    }

    public void setvAPWhitePopulation(double vAPWhitePopulation) {
        this.vAPWhitePopulation = vAPWhitePopulation;
    }

    public double getvAPBlackPopulation() {
        return vAPBlackPopulation;
    }

    public void setvAPBlackPopulation(double vAPBlackPopulation) {
        this.vAPBlackPopulation = vAPBlackPopulation;
    }

    public double getvAPHispanicPopulation() {
        return vAPHispanicPopulation;
    }

    public void setvAPHispanicPopulation(double vAPHispanicPopulation) {
        this.vAPHispanicPopulation = vAPHispanicPopulation;
    }

    public double getvAPAmericanIndianPopulation() {
        return vAPAmericanIndianPopulation;
    }

    public void setvAPAmericanIndianPopulation(double vAPAmericanIndianPopulation) {
        this.vAPAmericanIndianPopulation = vAPAmericanIndianPopulation;
    }

    public double getvAPAsianPopulation() {
        return vAPAsianPopulation;
    }

    public void setvAPAsianPopulation(double vAPAsianPopulation) {
        this.vAPAsianPopulation = vAPAsianPopulation;
    }

    public double getvAPHawaiianPopulation() {
        return vAPHawaiianPopulation;
    }

    public void setvAPHawaiianPopulation(double vAPHawaiianPopulation) {
        this.vAPHawaiianPopulation = vAPHawaiianPopulation;
    }

    public double getvAPOtherPopulation() {
        return vAPOtherPopulation;
    }

    public void setvAPOtherPopulation(double vAPOtherPopulation) {
        this.vAPOtherPopulation = vAPOtherPopulation;
    }

    public double getcVAPTotalPopulation() {
        return cVAPTotalPopulation;
    }

    public void setcVAPTotalPopulation(double cVAPTotalPopulation) {
        this.cVAPTotalPopulation = cVAPTotalPopulation;
    }

    public double getcVAPWhitePopulation() {
        return cVAPWhitePopulation;
    }

    public void setcVAPWhitePopulation(double cVAPWhitePopulation) {
        this.cVAPWhitePopulation = cVAPWhitePopulation;
    }

    public double getcVAPBlackPopulation() {
        return cVAPBlackPopulation;
    }

    public void setcVAPBlackPopulation(double cVAPBlackPopulation) {
        this.cVAPBlackPopulation = cVAPBlackPopulation;
    }

    public double getcVAPHispanicPopulation() {
        return cVAPHispanicPopulation;
    }

    public void setcVAPHispanicPopulation(double cVAPHispanicPopulation) {
        this.cVAPHispanicPopulation = cVAPHispanicPopulation;
    }

    public double getcVAPAmericanIndianPopulation() {
        return cVAPAmericanIndianPopulation;
    }

    public void setcVAPAmericanIndianPopulation(double cVAPAmericanIndianPopulation) {
        this.cVAPAmericanIndianPopulation = cVAPAmericanIndianPopulation;
    }

    public double getcVAPAsianPopulation() {
        return cVAPAsianPopulation;
    }

    public void setcVAPAsianPopulation(double cVAPAsianPopulation) {
        this.cVAPAsianPopulation = cVAPAsianPopulation;
    }

    public double getcVAPHawaiianPopulation() {
        return cVAPHawaiianPopulation;
    }

    public void setcVAPHawaiianPopulation(double cVAPHawaiianPopulation) {
        this.cVAPHawaiianPopulation = cVAPHawaiianPopulation;
    }

    public double getcVAPOtherPopulation() {
        return cVAPOtherPopulation;
    }

    public void setcVAPOtherPopulation(double cVAPOtherPopulation) {
        this.cVAPOtherPopulation = cVAPOtherPopulation;
    }

    public double getDemocratVoters() {
        return democratVoters;
    }

    public void setDemocratVoters(double democratVoters) {
        this.democratVoters = democratVoters;
    }

    public double getRepublicanVoters() {
        return republicanVoters;
    }

    public void setRepublicanVoters(double republicanVoters) {
        this.republicanVoters = republicanVoters;
    }

    public double getOtherVoters() {
        return otherVoters;
    }

    public void setOtherVoters(double otherVoters) {
        this.otherVoters = otherVoters;
    }

    Map<Race, Double> minorityPopulation;
    Map<Race, Double> minorityVotingAgePopulation;

    public double calculatePopulationScore() {
        return 0;
    }

    public void addPopulation(Population population) {
        numMinority += population.getNumMinority();
        totalPopulation += population.getTotalPopulation();
        vaPopulation += population.getVaPopulation();
        cvaPopulation += population.getCvaPopulation();
        numDemocraticParty += population.getNumDemocraticParty();
        numRepublicanParty += population.getNumRepublicanParty();
    }

    public void removePopulation(Population population) {
        numMinority -= population.getNumMinority();
        totalPopulation -= population.getTotalPopulation();
        vaPopulation -= population.getVaPopulation();
        cvaPopulation -= population.getCvaPopulation();
        numDemocraticParty -= population.getNumDemocraticParty();
        numRepublicanParty -= population.getNumRepublicanParty();
    }

    @Id
    public String getId() {
        return geoID20;
    }

    public void setId(String id) {
        this.geoID20 = id;
    }

    public double getSpecificPopulation(Race race) {
        return minorityPopulation.get(race);
    }

    public double getSpecificVotingAgePopulation(Race race) {
        return minorityPopulation.get(race);
    }

    public int getNumMinority() {
        return numMinority;
    }

    public int getTotalPopulation() {
        return totalPopulation;
    }

    public int getVaPopulation() {
        return vaPopulation;
    }

    public int getCvaPopulation() {
        return cvaPopulation;
    }

    public int getNumDemocraticParty() {
        return numDemocraticParty;
    }

    public int getNumRepublicanParty() {
        return numRepublicanParty;
    }

    public void setNumMinority(int numMinority) {
        this.numMinority = numMinority;
    }

    public void setTotalPopulation(int totalPopulation) {
        this.totalPopulation = totalPopulation;
    }

    public void setVaPopulation(int vaPopulation) {
        this.vaPopulation = vaPopulation;
    }

    public void setCvaPopulation(int cvaPopulation) {
        this.cvaPopulation = cvaPopulation;
    }

    public void setNumDemocraticParty(int numDemocraticParty) {
        this.numDemocraticParty = numDemocraticParty;
    }

    public void setNumRepublicanParty(int numRepublicanParty) {
        this.numRepublicanParty = numRepublicanParty;
    }

    //    public boolean isEqual(ClientFilterParameters clientFilterParameters) {
//        return isEqual;
//    }

}
