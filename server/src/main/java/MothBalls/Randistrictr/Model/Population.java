package MothBalls.Randistrictr.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;

@Entity
public class Population {

    private long id;
    private int numMinority;
    private int totalPopulation;
    private int vaPopulation;
    private int cvaPopulation;
    private int numDemocraticParty;
    private int numRepublicanParty;
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
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
