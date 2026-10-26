package EventManagement.entities;

public class User {
    private String id;
    private String name;
    private boolean isOrganizer;

    public User(String id, String name, boolean isOrganizer) {
        this.id = id;
        this.name = name;
        this.isOrganizer = isOrganizer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOrganizer() {
        return isOrganizer;
    }

    public void setOrganizer(boolean organizer) {
        isOrganizer = organizer;
    }
}
