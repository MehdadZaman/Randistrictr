package MothBalls.Randistrictr.Model;

import javax.persistence.*;

public class Precinct {
    private long id;
    private String state;

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
