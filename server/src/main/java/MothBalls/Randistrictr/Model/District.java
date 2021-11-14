package MothBalls.Randistrictr.Model;

import java.io.Serializable;
import java.util.*;

public class District implements Serializable {

    private Set<CensusBlock>  censusBlocks;
    private List<District> adjacentDistricts;
    private Map<District, Set<CensusBlock>> movableCensusBlocks;
    private Population population;
    private int id;
    private DistrictGeometry geometry;
    private Random random;

    public District(Set<CensusBlock> censusBlocks, List<District> adjacentDistricts,
                    Map<District, Set<CensusBlock>> movableCensusBlocks,
                    Population population, int id, DistrictGeometry geometry) {
        this.censusBlocks = censusBlocks;
        this.adjacentDistricts = adjacentDistricts;
        this.movableCensusBlocks = movableCensusBlocks;
        this.population = population;
        this.id = id;
        this.geometry = geometry;
        this.random = new Random();
    }

    public void modifyDistrict() {
        District neighborDistrict = getNeighboringDistrict();
        CensusBlock censusBlock = getCensusBlock();
        removeCensusBlock(censusBlock);
        neighborDistrict.addCensusBlock(censusBlock);
    }

    public boolean isOpportunityDistrict() {
        return false;
    }

    public double getOpportunityPercentage() {
        return 0;
    }

    public double calculateDistrictPopScore(int numDistricts) {
        return 0;
    }

    public District getNeighboringDistrict() {
        int randomIndex = random.nextInt(adjacentDistricts.size());
        return adjacentDistricts.get(randomIndex);
    }

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