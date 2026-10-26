import EventManagement.EventController;
import EventManagement.EventModuleDemo;
import EventManagement.entities.Event;
import EventManagement.entities.User;
import parkingLot.ParkingController;
import parkingLot.VEHICLE_TYPE;
import parkingLot.parkingStrategy.FirstAvailableSpotSelectionStrategy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //ttt
//    GameController gameController = new GameController();
//    gameController.start();



    //parking-lot
//    ParkingController parkingController = new ParkingController(new FirstAvailableSpotSelectionStrategy());
//    String ticketId = parkingController.entry("123", VEHICLE_TYPE.TWO_WHEELER);
//    try {
//        Thread.sleep(2000);
//    } catch (InterruptedException e) {
//        throw new RuntimeException(e);
//    }
//    Long amount = parkingController.exit("123");
//    System.out.println("Parking fee:"+ amount);

    //Event Module
    EventModuleDemo eventModuleDemo = new EventModuleDemo();
    eventModuleDemo.run();
}
