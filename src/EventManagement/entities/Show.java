package EventManagement.entities;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Show {
    private String id;
    private String venueId;
    private String hallId;
    private String eventId;
    private Instant startTime;
    private Instant endTime;
    private Set<String> bookedSeatNumbers = new HashSet<>();

    public Show(String id, String venueId, String hallId, String eventId, Instant startTime, Instant endTime, Set<String> bookedSeatNumbers) {
        this.id = id;
        this.venueId = venueId;
        this.hallId = hallId;
        this.eventId = eventId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bookedSeatNumbers = bookedSeatNumbers;
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

    public Set<String> getBookedSeatNumbers() {
        return bookedSeatNumbers;
    }

    public void setBookedSeatNumbers(Set<String> bookedSeatNumbers) {
        this.bookedSeatNumbers = bookedSeatNumbers;
    }

    void reserveSeats(){

    }
}
