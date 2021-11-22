package mothballs.randistrictr.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class BoxPlot implements Serializable {

    @Id
    private String id;

    private int whiskerPosition;
    private int basis;
    private String state;

    private double minimum;
    private double firstQuartile;
    private double median;
    private double thirdQuartile;
    private double maximum;
}