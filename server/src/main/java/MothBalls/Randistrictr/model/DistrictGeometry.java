package MothBalls.Randistrictr.model;

import java.util.*;

public class DistrictGeometry extends Geometry{

    private String boundaryColor;
    private boolean isVisible;

    public DistrictGeometry(List<double[]> coordinates) {
        super(coordinates);
    }

    private void addGeometry(Geometry cbGeometry) {
        return;
    }

    public void deleteGeometry(Geometry cbGeometry) {
        return;
    }

    private double computePerimeter() {
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
