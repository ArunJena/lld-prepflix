package EventManagement.repositories;

import EventManagement.entities.Show;

import java.util.List;
import java.util.Optional;

public interface IShowRepositories {
    Optional<Show> findById(String showId);
    List<Show> findByHallId(String hallId);
    List<Show> findAll();
    void save(Show show);
}
