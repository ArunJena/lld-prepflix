package parkingLot;

public class Vehicle {
    private String number;

    public Vehicle(String number, VEHICLE_TYPE type) {
        this.number = number;
        this.type = type;
    }

    private VEHICLE_TYPE type;
}
