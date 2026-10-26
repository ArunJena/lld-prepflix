package EventManagement;

import EventManagement.entities.*;

import java.time.Instant;
import java.util.*;

public class EventController {
    HashMap<String, Show> showIdToShowHM = new HashMap<>();
    HashMap<String, Venue> venueIdToVenueHM = new HashMap<>();
    HashMap<String, Hall> hallIdToHallHM = new HashMap<>();
    HashMap<String, List<String>> hallIdToShowIdHM = new HashMap<>();
    HashMap<String, Seat> seatIdToSeatHM = new HashMap<>();

    public String createVenue(int numberOfHalls, User user){
        //Assuming all the halls are same, have 1A-1Z, till 9A-9Z : 26x9 seats
        if(!user.isOrganizer()){
            System.out.println("Cannot create event, user is not organizer.");
            return "false";
        }
        String venueId = UUID.randomUUID().toString();
        List<Hall> halls = new ArrayList<>();
        for(int i=0; i<numberOfHalls; i++){
            String hallId = venueId + i;
            Hall hall = new Hall(hallId, venueId, new ArrayList<>());
            List<Seat> seats = new ArrayList<>();
            for(int j=0; j<26*9; j++){
                Seat seat = new Seat(venueId + hallId + j, ""+j, hallId, venueId, false);
                seatIdToSeatHM.put(seat.getId(), seat);
                seats.add(seat);
            }
            hall.setSeats(seats);
            halls.add(hall);
            hallIdToHallHM.put(hall.getId(), hall);
        }

        Venue venue = new Venue(venueId, halls);
        venueIdToVenueHM.put(venueId, venue);
        System.out.println("Venue created with id: "+ venueId);
        return venueId;
    }

    //can have strategy pattern to use different createShow strategy
    public String createShow(String eventId, String venueId, String hallId, Instant startTime, Instant endTime, User user){
        if(!user.isOrganizer()){
            System.out.println("User is not organizer");
            return "false";
        }

        //if hall is occupied in that duration return false
        List<String> showIdsInGivenHall = hallIdToShowIdHM.get(hallId);
        if(showIdsInGivenHall == null) showIdsInGivenHall = new ArrayList<>();
        for(String showId: showIdsInGivenHall){
            Show show = showIdToShowHM.get(showId);
            if(isOverlap(startTime, endTime, show.getStartTime(), show.getEndTime())){
                System.out.println("Cannot creat the show, overlapping with showId: "+ showId);
                return "false";
            }
        }

        Show show = new Show(eventId + hallId, venueId, hallId, eventId, startTime, endTime, new ArrayList<>());
        showIdToShowHM.put(show.getId(), show);
        hallIdToShowIdHM
                .computeIfAbsent(hallId, k -> new ArrayList<>())
                .add(show.getId());
        System.out.println("Created show with showId: "+show.getId());

        return show.getId();
    }

    private boolean isOverlap(Instant start1, Instant end1, Instant start2, Instant end2){
        return start1.isBefore(end2) && start2.isBefore(end1);
    }

    public List<Show> listShows(String eventId, String venueId, Instant startTime){
        return showIdToShowHM.values().stream()
                .filter(s -> eventId==null || eventId.equals(s.getEventId()))
                .filter(s -> venueId==null || venueId.equals(s.getVenueId()))
                .filter(s -> startTime==null || startTime.equals(s.getStartTime()))
                .toList();
    }

    public Ticket reserveSeats(String showId, User user){
        //get available seats
        Show show = showIdToShowHM.get(showId);
        List<String> availableSeatNumbers = new ArrayList<>();
        List<String> bookedSeatNumbers = show.getBookedSeatNumbers();
        for(int i=0; i<26*9; i++){
            if(!bookedSeatNumbers.contains(i+"")) availableSeatNumbers.add(i+"");
        }


        //let user choose seat numbers and validate
        Scanner sc = new Scanner(System.in);
        ArrayList<String> selectedSeatNumbers = new ArrayList<>();
        while(true){
            System.out.println("Enter any of the available seats separated by spaces: "+availableSeatNumbers);
            String input = sc.nextLine();
            selectedSeatNumbers = new ArrayList<>(
                    Arrays.asList(input.trim().split("\\s+"))
            );

            boolean isInvalidSeatSelected = false;
            for(String selectedSeatNumber: selectedSeatNumbers){
                if(bookedSeatNumbers.contains(selectedSeatNumber)){
                    System.out.println("Invalid seat numbers");
                    isInvalidSeatSelected = true;
                    break;
                }
            }
            if(isInvalidSeatSelected) continue;
            else break;
        }


        //book seats
        for(String selectedSeatNumber: selectedSeatNumbers){
            show.getBookedSeatNumbers().add(selectedSeatNumber);
        }
        Ticket ticket = new Ticket(UUID.randomUUID().toString(), showId, user.getId(), selectedSeatNumbers);
        System.out.println("Ticket booked with ticketId: "+ ticket.getId());
        return ticket;
    }
}
