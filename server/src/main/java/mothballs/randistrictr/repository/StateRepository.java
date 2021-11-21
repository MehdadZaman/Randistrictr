package mothballs.randistrictr.repository;

import mothballs.randistrictr.model.State;
import org.springframework.data.repository.CrudRepository;

public interface StateRepository extends CrudRepository<State, String> {
    State findStateByState(String stateName);
}
