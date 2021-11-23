package mothballs.randistrictr.model;

import javax.persistence.*;
import java.io.*;
import java.util.*;

@Entity
public class DistrictingPlan implements Serializable {

    @Id
    String id;

    @OneToOne
    @JoinColumn(name="id", referencedColumnName="id")
    private DistrictingPlanStatistics districtingPlanStatistics;

    private String state;
    private int districtingPlan;

    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name="state", referencedColumnName="state"),
            @JoinColumn(name="districtingPlan", referencedColumnName="districtingPlan")
    })
    private List<District> districts;

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

    public int getDistrictingPlan() {
        return districtingPlan;
    }

    public void setDistrictingPlan(int districtingPlan) {
        this.districtingPlan = districtingPlan;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    public DistrictingPlanStatistics getDistrictingPlanStatistics() {
        return districtingPlanStatistics;
    }

    public void setDistrictingPlanStatistics(DistrictingPlanStatistics districtingPlanStatistics) {
        this.districtingPlanStatistics = districtingPlanStatistics;
    }

    @Transient
    public District selectDistrict() {
        return districts.get((int)(Math.random() * districts.size()));
    }

    @Transient
    public void makeMove(CensusBlock censusBlock) {
        District removedFrom = null;
        District addedTo = null;

        for(District district : districts) {
            if(censusBlock.getCongressionalDistrict().equals(district.getCongressionalDistrict())) {
                removedFrom = district;
            }

            if(censusBlock.getAdjacentCongressionalDistrict().equals(district.getCongressionalDistrict())) {
                addedTo = district;
            }
        }

        removedFrom.removeCensusBlock(censusBlock, addedTo);
        addedTo.addCensusBlock(censusBlock, removedFrom);

        censusBlock.setDistrictingPlan(addedTo.getDistrictingPlan());
        censusBlock.setAdjacentCongressionalDistrict(removedFrom.getCongressionalDistrict());
    }

    @Transient
    public void recalculateMeasures() {
        this.districtingPlanStatistics.setAbsoluteDifferenceInPopulation(getAbsPopDiff());
        int numOppDistricts = 0;
        for(District district : districts) {
            if(district.isOpportunityDistrict()) {
                numOppDistricts++;
            }
        }
        this.districtingPlanStatistics.setNumOpportunityDistricts(numOppDistricts);
    }

    @Transient
    public double getAbsPopDiff() {
        double maxPop = Double.MIN_VALUE;
        double minPop = Double.MAX_VALUE;
        double totalPop = 0;
        for(District district : districts) {
            maxPop = Math.max(maxPop, district.getPopulation().getTotalTotalPopulation());
            minPop = Math.min(minPop, district.getPopulation().getTotalTotalPopulation());
            totalPop += district.getPopulation().getTotalTotalPopulation();
        }
        return (maxPop - minPop) / totalPop;
    }

    @Transient
    public void instantiateDataStructures(District district) {
        List<String> adjacentDistrictIDs = district.getAdjacentDistrictIDs();
        List<District> adjacentDistricts = new ArrayList<>();

        HashMap<String, District> idMappings = new HashMap<>();

        for(String adjID : adjacentDistrictIDs) {
            for(District otherDistrict : districts) {
                idMappings.put(district.getGeoID20(), otherDistrict);
                if(otherDistrict.getGeoID20().equals(adjID)) {
                    adjacentDistricts.add(otherDistrict);
                }
            }
        }

        Map<District, Set<CensusBlock>> movableCensusBlocks = new HashMap<>();
        Set<CensusBlock> censusBlocks = district.getCensusBlocks();

        for(CensusBlock censusBlock : censusBlocks) {
            if((censusBlock.getAdjacentCongressionalDistrict() != null) && (!censusBlock.getAdjacentCongressionalDistrict().equals(censusBlock.getCongressionalDistrictID()))) {
                if(movableCensusBlocks.containsKey(idMappings.get(censusBlock.getAdjacentCongressionalDistrict()))) {
                    movableCensusBlocks.get(idMappings.get(censusBlock.getAdjacentCongressionalDistrict())).add(censusBlock);
                }
                else {
                    movableCensusBlocks.put(idMappings.get(censusBlock.getAdjacentCongressionalDistrict()), new HashSet<>());
                    movableCensusBlocks.get(idMappings.get(censusBlock.getAdjacentCongressionalDistrict())).add(censusBlock);
                }
            }

        }

        district.setAdjacentDistricts(adjacentDistricts);
        district.setMovableCensusBlocks(movableCensusBlocks);
    }

//    @Transient
//    public DistrictingPlan deepClone() {
//        try {
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
//            objectOutputStream.writeObject(this);
//
//            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
//            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
//            return (DistrictingPlan) objectInputStream.readObject();
//        } catch (Exception e) {
//            return null;
//        }
//    }

//    public double calculateDistrictingPlanScore() {
//        return 0;
//    }
}
