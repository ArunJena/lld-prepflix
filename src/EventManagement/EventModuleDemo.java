package EventManagement;

import EventManagement.entities.Event;
import EventManagement.entities.Show;
import EventManagement.entities.User;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public class EventModuleDemo {
    public void run(){
        EventController eventController = new EventController();
        Event event1 = new Event("1", "A");
        Event event2 = new Event("2", "B");
        User user1 = new User("u1", "John", false);
        User user2 = new User("u2", "Doe", true);
        String venueId1 = eventController.createVenue(100, user1);
        String venueId2 = eventController.createVenue(3, user2);

        String showId1 = eventController.createShow(event1.getId(),
                venueId2,
                venueId2+"1",
                LocalDateTime
                        .of(2026, 10, 25, 14, 30)
                        .atZone(ZoneId.of("Asia/Kolkata"))
                        .toInstant(),
                LocalDateTime
                        .of(2026, 10, 25, 15, 30)
                        .atZone(ZoneId.of("Asia/Kolkata"))
                        .toInstant(),
                user2);

        String showId2 = eventController.createShow(event1.getId(),
                venueId2,
                venueId2+"1",
                LocalDateTime
                        .of(2026, 10, 25, 14, 30)
                        .atZone(ZoneId.of("Asia/Kolkata"))
                        .toInstant(),
                LocalDateTime
                        .of(2026, 10, 25, 16, 30)
                        .atZone(ZoneId.of("Asia/Kolkata"))
                        .toInstant(),
                user2);

        List<Show> events = eventController.listShows("1", null, null);
        System.out.println("Listing events: "+events);

        eventController.reserveSeats(showId1, user1);
    }
}
