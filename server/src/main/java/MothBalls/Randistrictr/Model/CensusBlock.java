package MothBalls.Randistrictr.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class CensusBlock {

    private long id;
    private Geometry geometry;
    private Population population;

//    public CensusBlock(Geometry geometry, Population population, int id) {
//        this.geometry = geometry;
//        this.population = population;
//        this.id = id;
//    }

    @Transient
    public List<double[]> getGeometries() {
        return geometry.getBoundaries();
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    @OneToOne
    public Population getPopulation() {
        return population;
    }

    public void setPopulation(Population population) {
        this.population = population;
    }

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
