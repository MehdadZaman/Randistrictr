package MothBalls.Randistrictr.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CensusBlock implements Serializable {
    @Id
    private String geoID20;

    private String state;
    private String congressionalDistrict;
    private int districtingPlan;
    private String precinctID;

    private String geometryType;

    @Lob
    private String geometry;

    public int getDistrictingPlan() {
        return districtingPlan;
    }

    public void setDistrictingPlan(int districtingPlan) {
        this.districtingPlan = districtingPlan;
    }

    // private Population class
    @OneToOne
    @PrimaryKeyJoinColumn
    private Population population;

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

    public String getPrecinctID() {
        return precinctID;
    }

    public void setPrecinctID(String precinctID) {
        this.precinctID = precinctID;
    }

    public String getGeometryType() {
        return geometryType;
    }

    public void setGeometryType(String geometryType) {
        this.geometryType = geometryType;
    }

    public String getGeometry() {
        return geometry;
    }

    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }

    public Population getPopulation() {
        return population;
    }

    public void setPopulation(Population population) {
        this.population = population;
    }
}
