package MothBalls.Randistrictr.model;

import java.io.Serializable;
import java.util.*;

public class Geometry implements Serializable {

    private List<double[]> coordinates;
    private double area;
    private double perimeter;

    public Geometry(List<double[]> coordinates) {
        this.coordinates = coordinates;
    }

    public double computeArea() {
        area = 0;
        return area;
    }

    private double computePerimeter() {
        perimeter = 0;
        return perimeter;
    }

    public List<double[]> getCoordinates() {
        return coordinates;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

}
