package mothballs.randistrictr.repository;

import mothballs.randistrictr.model.Population;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PopulationRepository extends CrudRepository<Population, String> {

//    List<Population> findByTotalTotalPopulation(double totalTotalPopulation);

    Population findByGeoID20(String geoID20);
    List<Population> findAllByGeoID20Containing(String id);
    List<Population> findAllByGeoID20(String geoID20);

}
