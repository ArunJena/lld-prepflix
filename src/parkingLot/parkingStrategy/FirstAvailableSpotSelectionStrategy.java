package parkingLot.parkingStrategy;

import parkingLot.ParkingLot;
import parkingLot.ParkingSpot;
import parkingLot.VEHICLE_TYPE;

import java.util.Optional;

public class FirstAvailableSpotSelectionStrategy implements ISpotSelectionStrategy{

    @Override
    public ParkingSpot findSpot(ParkingLot parkingLot, VEHICLE_TYPE vehicleType) {
        return parkingLot.getParkingSpots()[0];
    }
}
