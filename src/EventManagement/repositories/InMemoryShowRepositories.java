package EventManagement.repositories;

import EventManagement.entities.Show;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryShowRepositories implements IShowRepositories {
    private Map<String, Show> showIdToShowHM = new HashMap<>();

    @Override
    public Optional<Show> findById(String showId) {
        return Optional.ofNullable(showIdToShowHM.get(showId));
    }

    @Override
    public List<Show> findByHallId(String hallId) {
        return showIdToShowHM.values().stream().filter(s-> s.getHallId().equals(hallId)).toList();
    }

    @Override
    public List<Show> findAll() {
        return showIdToShowHM.values().stream().toList();
    }

    @Override
    public void save(Show show) {
        showIdToShowHM.put(show.getId(), show);
    }
}
