package MothBalls.Randistrictr.Model;

import java.util.*;

public class DistrictGeometry extends Geometry{

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
        List<double[]> coordinates = getCoordinates();
        coordinates.removeAll(cbGeometry);
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
