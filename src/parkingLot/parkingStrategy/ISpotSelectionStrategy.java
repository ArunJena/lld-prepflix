package parkingLot.parkingStrategy;

import parkingLot.ParkingLot;
import parkingLot.ParkingSpot;
import parkingLot.VEHICLE_TYPE;

import java.util.Optional;

public interface ISpotSelectionStrategy {
    ParkingSpot findSpot(ParkingLot parkingLot, VEHICLE_TYPE vehicleType);
}
