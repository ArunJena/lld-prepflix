package parkingLot;

import java.time.Instant;

public class ParkingTicket {
    private String id;
    private VEHICLE_TYPE type;
    private Instant entryTime;
    private Instant exitTime;
    private String spotId;
    private String vehicleId;

    public ParkingTicket(String id, VEHICLE_TYPE type, Instant entryTime, Instant exitTime, String spotId, String vehicleId) {
        this.id = id;
        this.type = type;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.spotId = spotId;
        this.vehicleId = vehicleId;
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

    public Instant getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Instant entryTime) {
        this.entryTime = entryTime;
    }

    public Instant getExitTime() {
        return exitTime;
    }

    public void setExitTime(Instant exitTime) {
        this.exitTime = exitTime;
    }

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }
}
