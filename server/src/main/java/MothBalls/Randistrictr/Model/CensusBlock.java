package MothBalls.Randistrictr.model;

import java.io.Serializable;

public class CensusBlock implements Serializable {
    private Geometry geometry;
    private Population population;
    private int id;

    public CensusBlock(Geometry geometry, Population population, int id) {
        this.geometry = geometry;
        this.population = population;
        this.id = id;
    }

    public double[] getGeometries() {
        return null;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public Population getPopulation() {
        return population;
    }

    public void setPopulation(Population population) {
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
