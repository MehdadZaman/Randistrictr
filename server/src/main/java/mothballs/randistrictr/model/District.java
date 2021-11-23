package mothballs.randistrictr.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class District implements Serializable {

    @Id
    private String geoID20;

    private String state;
    private String congressionalDistrict;
    private int districtingPlan;

    @ElementCollection
    private List<String> adjacentDistrictIDs;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Population population;

    @OneToMany //(fetch=FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name="congressionalDistrictID", referencedColumnName="geoID20")
    })
    private Set<CensusBlock> censusBlocks;

    @Transient
    private List<District> adjacentDistricts;

    @Transient
    private Map<District, Set<CensusBlock>> movableCensusBlocks;

    @Transient
    private Random random;

    public String getGeoID20() {
        return geoID20;
    }

    public void setGeoID20(String geoID20) {
        this.geoID20 = geoID20;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCongressionalDistrict() {
        return congressionalDistrict;
    }

    public void setCongressionalDistrict(String congressionalDistrict) {
        this.congressionalDistrict = congressionalDistrict;
    }

    public int getDistrictingPlan() {
        return districtingPlan;
    }

    public void setDistrictingPlan(int districtingPlan) {
        this.districtingPlan = districtingPlan;
    }

    public List<District> getAdjacentDistricts() {
        return adjacentDistricts;
    }

    public void setAdjacentDistricts(List<District> adjacentDistricts) {
        this.adjacentDistricts = adjacentDistricts;
    }

    public Set<CensusBlock> getCensusBlocks() {
        return censusBlocks;
    }

    public void setCensusBlocks(Set<CensusBlock> censusBlocks) {
        this.censusBlocks = censusBlocks;
    }

    public Map<District, Set<CensusBlock>> getMovableCensusBlocks() {
        return movableCensusBlocks;
    }

    public void setMovableCensusBlocks(Map<District, Set<CensusBlock>> movableCensusBlocks) {
        this.movableCensusBlocks = movableCensusBlocks;
    }

    public Population getPopulation() {
        return population;
    }

    public void setPopulation(Population population) {
        this.population = population;
    }

    @Transient
    public District getNeighboringDistrict() {
        int randomIndex = random.nextInt(adjacentDistricts.size());
        return adjacentDistricts.get(randomIndex);
    }


    public List<String> getAdjacentDistrictIDs() {
        return adjacentDistrictIDs;
    }

    public void setAdjacentDistrictIDs(List<String> adjacentDistrictIDs) {
        this.adjacentDistrictIDs = adjacentDistrictIDs;
    }

    @Transient
    public CensusBlock selectCensusBlock() {
        District randomNeighboringDistrict = adjacentDistricts.get((int)Math.random() * adjacentDistricts.size());
        Set<CensusBlock> selectedCensusBlocks = movableCensusBlocks.get(randomNeighboringDistrict);
        int randomIndex = (int)Math.random() * selectedCensusBlocks.size();
        int iter = 0;
        for(CensusBlock cB : selectedCensusBlocks) {
            if(iter == randomIndex) {
                return cB;
            }
            iter++;
        }
        return null;
    }

    @Transient
    public void addCensusBlock(CensusBlock censusBlock, District neighboringDistrict) {
        movableCensusBlocks.get(neighboringDistrict).remove(censusBlock);
        censusBlocks.add(censusBlock);
        population.addPopulation(censusBlock.getPopulation());
    }

    @Transient
    public void removeCensusBlock(CensusBlock censusBlock, District neighboringDistrict) {
        movableCensusBlocks.get(neighboringDistrict).add(censusBlock);
        censusBlocks.remove(censusBlock);
        population.removePopulation(censusBlock.getPopulation());
    }

//    @Transient
//    public boolean isOpportunityDistrict() {
//        return false;
//    }

}
