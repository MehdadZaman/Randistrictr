package MothBalls.Randistrictr.model;

import MothBalls.Randistrictr.object.Geometry;

import java.util.*;

public class DistrictGeometry extends Geometry {

    private String boundaryColor;
    private boolean isVisible;

    public DistrictGeometry(List<double[]> coordinates) {
        super(coordinates);
    }

    public void addGeometry(List<double[]> cbGeometry) {
        List<double[]> coordinates = getCoordinates();
        coordinates.addAll(cbGeometry);
        setCoordinates(coordinates);
    }

    public void removeGeometry(List<double[]> cbGeometry) {
        List<double[]> coordinates = new ArrayList<>(getCoordinates());
        for (double[] coordinate1 : cbGeometry) {
            for (double[] coordinate2 : getCoordinates()) {
                if (coordinate1[0] == coordinate2[0] && coordinate1[1] == coordinate2[1]) {
                    coordinates.remove(coordinate2);
                }
            }
        }
        setCoordinates(coordinates);
    }

    public double computePerimeter() {
        return 0;
    }

    public String getBoundaryColor() {
        return boundaryColor;
    }

    public void setBoundaryColor(String boundaryColor) {
        this.boundaryColor = boundaryColor;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisibility(boolean visible) {
        isVisible = visible;
    }
}
