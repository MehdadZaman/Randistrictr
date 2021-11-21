package MothBalls.Randistrictr.repository;

import MothBalls.Randistrictr.model.CensusBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CensusBlockRepository extends JpaRepository<CensusBlock, String> {
}
