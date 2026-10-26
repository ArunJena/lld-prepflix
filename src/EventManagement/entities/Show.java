package EventManagement.entities;

import java.time.Instant;
import java.util.List;

public class Show {
    private String id;
    private String venueId;
    private String hallId;
    private String eventId;
    private Instant startTime;
    private Instant endTime;
    private List<Seat> bookedSeats;

    public Show(String id, String venueId, String hallId, String eventId, Instant startTime, Instant endTime, List<Seat> bookedSeats) {
        this.id = id;
        this.venueId = venueId;
        this.hallId = hallId;
        this.eventId = eventId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bookedSeats = bookedSeats;
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

    public String getHallId() {
        return hallId;
    }

    public void setHallId(String hallId) {
        this.hallId = hallId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<Seat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    void reserveSeats(){

    }
}
