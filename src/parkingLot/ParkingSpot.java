package parkingLot;

public class ParkingSpot {
    private String id;
    private VEHICLE_TYPE type;
    private boolean isOccupied;

    public ParkingSpot(VEHICLE_TYPE type, String id, boolean isOccupied) {
        this.type = type;
        this.id = id;
        this.isOccupied = isOccupied;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VEHICLE_TYPE getType() {
        return type;
    }

    public void setType(VEHICLE_TYPE type) {
        this.type = type;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
