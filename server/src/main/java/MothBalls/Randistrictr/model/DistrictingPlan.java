package mothballs.randistrictr.model;

import javax.persistence.*;
import java.io.*;
import java.util.List;

@Entity
public class DistrictingPlan implements Serializable {

    @Id
    String id;

    private String state;
    private int districtingPlan;

    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name="state", referencedColumnName="state"),
            @JoinColumn(name="districtingPlan", referencedColumnName="districtingPlan")
    })
    private List<District> districts;

//    private Random random;
//    private DistrictingPlanStatistics dps;


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

//    public DistrictingPlan(int redistrictNumber, List<District> districts) {
//        this.redistrictNumber = redistrictNumber;
//        this.districts = districts;
//        this.random = new Random();
//    }

//    @Transient
//    public JSONObject getJSON() {
//        Gson gson = new Gson();
//        String jsonString = gson.toJson(this);
//        return gson.fromJson(jsonString, JSONObject.class);
//    }

//    public District selectDistrict() {
//        int randomIndex = random.nextInt(districts.size());
//        int i = 0;
//        for (District district : districts) {
//            if (randomIndex == i) {
//                return district;
//            }
//            i++;
//        }
//        return null;
//    }

//    public void runSimulatedAnnealing() {
//        District district = selectDistrict();
//        district.modifyDistrict();
//    }

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
//
//    public void recalculateMeasures() {
//        return;
//    }
//
//    public List<double[]> getFilteredBoundaries(boolean isState, boolean isCong, boolean isCensusBlock) {
//        return null;
//    }
//
//    public List<double[]> appendToAggregateCoordinates(List<double[]> coordinates) {
//        return null;
//    }


//    public DistrictingPlanStatistics getDistrictingPlanStatistics() {
//        return dps;
//    }
//
//    public void setDistrictingPlanStatistics(DistrictingPlanStatistics dps) {
//        this.dps = dps;
//    }
}
