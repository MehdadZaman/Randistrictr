package MothBalls.Randistrictr.repository;

import MothBalls.Randistrictr.model.Population;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PopulationRepository extends CrudRepository<Population, String> {

//    List<Population> findByTotalTotalPopulation(double totalTotalPopulation);

    Population findByGeoID20(String geoID20);
}
