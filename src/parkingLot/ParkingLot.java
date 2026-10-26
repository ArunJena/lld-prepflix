package parkingLot;

public class ParkingLot {
    private ParkingSpot[] parkingSpots;

    public ParkingLot() {
        parkingSpots = new ParkingSpot[Config.TWO_WHEELER_SPOTS + Config.FOUR_WHEELER_SPOTS];
        for(int i=0; i<Config.TWO_WHEELER_SPOTS; i++){
            parkingSpots[i] = new ParkingSpot(VEHICLE_TYPE.TWO_WHEELER, Integer.toString(i), false );
        }
        for(int i=100; i<Config.TWO_WHEELER_SPOTS + Config.FOUR_WHEELER_SPOTS; i++){
            parkingSpots[i] = new ParkingSpot(VEHICLE_TYPE.FOUR_WHEELER, Integer.toString(i), false );
        }
    }

    public ParkingSpot[] getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(ParkingSpot[] parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
}
