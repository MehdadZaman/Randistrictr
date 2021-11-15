package MothBalls.Randistrictr.model;

import com.google.gson.Gson;
import org.json.simple.JSONObject;

import javax.persistence.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Random;

@Entity
public class DistrictingPlan {

    private int redistrictNumber;
    private List<District> districts;
    private Random random;
    private DistrictingPlanStatistics dps;


//    public DistrictingPlan(int redistrictNumber, List<District> districts) {
//        this.redistrictNumber = redistrictNumber;
//        this.districts = districts;
//        this.random = new Random();
//    }

    @Transient
    public JSONObject getJSON() {
        Gson gson = new Gson();
        String jsonString = gson.toJson(this);
        return gson.fromJson(jsonString, JSONObject.class);
    }

    public District selectDistrict() {
        int randomIndex = random.nextInt(districts.size());
        int i = 0;
        for (District district : districts) {
            if (randomIndex == i) {
                return district;
            }
            i++;
        }
        return null;
    }

    public void runSimulatedAnnealing() {
        District district = selectDistrict();
        district.modifyDistrict();
    }

    public DistrictingPlan deepClone() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return (DistrictingPlan) objectInputStream.readObject();
        } catch (Exception e) {
            return null;
        }
    }

    public double calculateDistrictingPlanScore() {
        return 0;
    }

    public void recalculateMeasures() {
        return;
    }

    public List<double[]> getFilteredBoundaries(boolean isState, boolean isCong, boolean isCensusBlock) {
        return null;
    }

    public List<double[]> appendToAggregateCoordinates(List<double[]> coordinates) {
        return null;
    }

    @OneToOne
    public DistrictingPlanStatistics getDistrictingPlanStatistics() {
        return dps;
    }

    public void setDistrictingPlanStatistics(DistrictingPlanStatistics dps) {
        this.dps = dps;
    }


    @Id
    public int getRedistrictNumber() {
        return redistrictNumber;
    }

    public void setRedistrictNumber(int redistrictNumber) {
        this.redistrictNumber = redistrictNumber;
    }

    @OneToMany
    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }


}
