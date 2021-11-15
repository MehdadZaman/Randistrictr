package MothBalls.Randistrictr.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class District {

    private long id;
    private List<District> adjacentDistricts;
    private Set<CensusBlock>  censusBlocks;
    private Map<District, Set<CensusBlock>> movableCensusBlocks;
    private Population population;
    private DistrictGeometry geometry;
    private Random random;

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToMany
    public List<District> getAdjacentDistricts() {
        return adjacentDistricts;
    }

    public void setAdjacentDistricts(List<District> adjacentDistricts) {
        this.adjacentDistricts = adjacentDistricts;
    }

    @Transient
    public Set<CensusBlock> getCensusBlocks() {
        return censusBlocks;
    }

    public void setCensusBlocks(Set<CensusBlock> censusBlocks) {
        this.censusBlocks = censusBlocks;
    }

    @Transient
    public Map<District, Set<CensusBlock>> getMovableCensusBlocks() {
        return movableCensusBlocks;
    }

    public void setMovableCensusBlocks(Map<District, Set<CensusBlock>> movableCensusBlocks) {
        this.movableCensusBlocks = movableCensusBlocks;
    }

    @OneToOne
    public Population getPopulation() {
        return population;
    }

    public void setPopulation(Population population) {
        this.population = population;
    }

    public DistrictGeometry getGeometry() {
        return geometry;
    }

    public void setGeometry(DistrictGeometry geometry) {
        this.geometry = geometry;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    //    public District(Set<CensusBlock> censusBlocks, List<District> adjacentDistricts,
//                    Map<District, Set<CensusBlock>> movableCensusBlocks,
//                    Population population, int id, DistrictGeometry geometry) {
//        this.censusBlocks = censusBlocks;
//        this.adjacentDistricts = adjacentDistricts;
//        this.movableCensusBlocks = movableCensusBlocks;
//        this.population = population;
//        this.id = id;
//        this.geometry = geometry;
//        this.random = new Random();
//    }

    public void modifyDistrict() {
        District neighborDistrict = getNeighboringDistrict();
        CensusBlock censusBlock = getCensusBlock();
        removeCensusBlock(censusBlock);
        neighborDistrict.addCensusBlock(censusBlock);
    }

    @Transient
    public boolean isOpportunityDistrict() {
        return false;
    }

    @Transient
    public double getOpportunityPercentage() {
        return 0;
    }

    public double calculateDistrictPopScore(int numDistricts) {
        return 0;
    }

    @Transient
    public District getNeighboringDistrict() {
        int randomIndex = random.nextInt(adjacentDistricts.size());
        return adjacentDistricts.get(randomIndex);
    }

    @Transient
    public CensusBlock getCensusBlock() {
        int randomIndex = random.nextInt(censusBlocks.size());
        int i = 0;
        for (CensusBlock censusBlock : censusBlocks) {
            if (i == randomIndex) {
                return censusBlock;
            }
            i++;
        }
        return null;
    }

    public void addCensusBlock(CensusBlock censusBlock) {
        censusBlocks.add(censusBlock);
    }

    public void removeCensusBlock(CensusBlock censusBlock) {
        censusBlocks.remove(censusBlock);
    }

    public void appendToDistrictCoordinateList(List<double[]> coordinates) {
        List<double[]> geometryCoordinates = geometry.getCoordinates();
        geometryCoordinates.addAll(coordinates);
    }
}
