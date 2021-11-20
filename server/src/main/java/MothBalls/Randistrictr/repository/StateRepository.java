package MothBalls.Randistrictr.repository;

import MothBalls.Randistrictr.model.Population;
import MothBalls.Randistrictr.model.State;
import org.springframework.data.repository.CrudRepository;

public interface StateRepository extends CrudRepository<State, String> {
    State findStateByState(String stateName);
}
