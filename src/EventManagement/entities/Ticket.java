package EventManagement.entities;

import java.util.List;

public class Ticket {
    String id;
    String showId;
    String userId;
    List<String> selectedSeatNumbers;

    public Ticket(String id, String showId, String userId, List<String> selectedSeatNumbers) {
        this.id = id;
        this.showId = showId;
        this.userId = userId;
        this.selectedSeatNumbers = selectedSeatNumbers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getSelectedSeatNumbers() {
        return selectedSeatNumbers;
    }

    public void setSelectedSeatNumbers(List<String> selectedSeatNumbers) {
        this.selectedSeatNumbers = selectedSeatNumbers;
    }
}
