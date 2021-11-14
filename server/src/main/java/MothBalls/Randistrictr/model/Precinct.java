package MothBalls.Randistrictr.model;

import javax.persistence.*;

@Entity
public class Precinct {
    private long id;
    private String state;

    @Id
    public long getId(){
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
