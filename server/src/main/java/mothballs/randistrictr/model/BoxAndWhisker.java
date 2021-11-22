package mothballs.randistrictr.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class BoxAndWhisker implements Serializable {

    @Id
    String id;

    private int basis;
    private String state;

    @OneToMany
    @JoinColumns({
            @JoinColumn(name="state", referencedColumnName="state"),
            @JoinColumn(name="basis", referencedColumnName="basis")
    })
    List<BoxPlot> boxes;
}