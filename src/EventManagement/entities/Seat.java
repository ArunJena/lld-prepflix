package EventManagement.entities;

public class Seat {
    private String id;
    private String seatNumber;
    private String hallId;
    private String VenueId;

    public Seat(String id, String seatNumber, String hallId, String venueId, boolean isBooked) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.hallId = hallId;
        VenueId = venueId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getHallId() {
        return hallId;
    }

    public void setHallId(String hallId) {
        this.hallId = hallId;
    }

    public String getVenueId() {
        return VenueId;
    }

    public void setVenueId(String venueId) {
        VenueId = venueId;
    }
}
