package mothballs.randistrictr.repository;

import mothballs.randistrictr.model.BoxAndWhisker;
import mothballs.randistrictr.model.State;
import mothballs.randistrictr.object.Basis;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoxAndWhiskerRepository extends CrudRepository<BoxAndWhisker, String> {
    BoxAndWhisker findByBasisAndState(Basis basis, String state);
}