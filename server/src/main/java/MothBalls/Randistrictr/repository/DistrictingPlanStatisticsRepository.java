package MothBalls.Randistrictr.repository;

import MothBalls.Randistrictr.model.DistrictingPlanStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictingPlanStatisticsRepository extends JpaRepository<DistrictingPlanStatistics, Integer> {
}