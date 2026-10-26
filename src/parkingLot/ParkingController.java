package parkingLot;

import parkingLot.parkingStrategy.ISpotSelectionStrategy;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;

public class ParkingController {
    private ParkingLot parkingLot = new ParkingLot();

    private HashMap<String, ParkingTicket> ticketIdToParkingTicket = new HashMap<>();
    private HashMap<String, String> vehicleNumberToTicketId = new HashMap<>();
    private ISpotSelectionStrategy spotSelectionStrategy;

    public ParkingController(ISpotSelectionStrategy spotSelectionStrategy){
        this.spotSelectionStrategy = spotSelectionStrategy;
    }


    private long calculatePrice(ParkingTicket ticket){
        if(ticket.getExitTime() == null) return -1;

        Duration duration = Duration.between(ticket.getEntryTime(), ticket.getExitTime());
        long hours = duration.toSeconds();
        System.out.println("Total hours spent: "+hours);

        long price = -1;
        switch (ticket.getType()){
            case VEHICLE_TYPE.TWO_WHEELER -> price = Config.TWO_WHEELER_PER_HOUR_PRICE * hours;
            case VEHICLE_TYPE.FOUR_WHEELER -> price = Config.FOUR_WHEELER_PER_HOUR_PRICE * hours;
        }
        return price;
    }


    public String entry(String vehicleNumber, VEHICLE_TYPE vehicleType){
        //find available spot
        ParkingSpot parkingSpot = spotSelectionStrategy.findSpot(parkingLot, vehicleType);

        ParkingTicket parkingTicket = new ParkingTicket(vehicleNumber + parkingSpot.getId(), vehicleType, Instant.now(), null, parkingSpot.getId(), vehicleNumber);
        ticketIdToParkingTicket.put(parkingTicket.getId(), parkingTicket);
        vehicleNumberToTicketId.put(vehicleNumber, parkingTicket.getId());
        System.out.println("Entry vehicle:"+vehicleNumber+", with ticket id: "+parkingTicket.getId());
        return parkingTicket.getId();
    }

    public long exit(String vehicleNumber){
        ParkingTicket ticket = ticketIdToParkingTicket.get(vehicleNumberToTicketId.get(vehicleNumber));
        ticket.setExitTime(Instant.now());

        long price = calculatePrice(ticket);
        ticketIdToParkingTicket.remove(ticket.getId());
        vehicleNumberToTicketId.remove(vehicleNumber);

        return price;
    }
}
