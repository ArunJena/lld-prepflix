package EventManagement.entities;

import java.util.List;

public class Venue {
    String id;
    List<Hall> halls;

    public Venue(String id, List<Hall> halls) {
        this.id = id;
        this.halls = halls;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Hall> getHalls() {
        return halls;
    }

    public void setHalls(List<Hall> halls) {
        this.halls = halls;
    }
}
