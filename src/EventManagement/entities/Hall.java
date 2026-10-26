package EventManagement.entities;

import java.util.List;

public class Hall {
    private String id;
    private String venueId;
    private List<Seat> seats;
    public Hall(String id, String venueId, List<Seat> seats) {
        this.id = id;
        this.venueId = venueId;
        this.seats = seats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
