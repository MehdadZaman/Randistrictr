package mothballs.randistrictr.object;

import java.io.Serializable;
import java.util.*;

public class Geometry implements Serializable {

    private String type;
    private List<List<double[]>> coordinates;
    private double area;
    private double perimeter;

    public Geometry(String type, List<List<double[]>> coordinates) {
        this.type = type;
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

    public List<List<double[]>> getBoundaries() {
        return coordinates;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public List<List<double[]>> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<List<double[]>> coordinates) {
        this.coordinates = coordinates;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }
}
