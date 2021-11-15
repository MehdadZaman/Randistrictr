package MothBalls.Randistrictr.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class CensusBlock {

    private String geoID20;
    private int state;
    private String cD116;
    private String precinctID;

    // private Geometry geometry;
    private List<double[]> geometry;
    private String geometryType;

    // private Population class
    private Population population;

    public String getGeoID20() {
        return geoID20;
    }

    public void setGeoID20(String geoID20) {
        this.geoID20 = geoID20;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getcD116() {
        return cD116;
    }

    public void setcD116(String cD116) {
        this.cD116 = cD116;
    }

    public String getPrecinctID() {
        return precinctID;
    }

    public void setPrecinctID(String precinctID) {
        this.precinctID = precinctID;
    }

    public List<double[]> getGeometry() {
        return geometry;
    }

    public void setGeometry(List<double[]> geometry) {
        this.geometry = geometry;
    }

    public String getGeometryType() {
        return geometryType;
    }

    public void setGeometryType(String geometryType) {
        this.geometryType = geometryType;
    }
//    public CensusBlock(Geometry geometry, Population population, int id) {
//        this.geometry = geometry;
//        this.population = population;
//        this.id = id;
//    }

    @Transient
    public List<double[]> getGeometries() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        // this.geometry = geometry;
    }

    @OneToOne
    public Population getPopulation() {
        return population;
    }

    public void setPopulation(Population population) {
        this.population = population;
    }

    @Id
    public String getId() {
        return geoID20;
    }

    public void setId(String id) {
        this.geoID20 = id;
    }
}
