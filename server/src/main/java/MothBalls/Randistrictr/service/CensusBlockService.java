package MothBalls.Randistrictr.service;

import MothBalls.Randistrictr.model.CensusBlock;
import MothBalls.Randistrictr.repository.CensusBlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CensusBlockService {
    @Autowired
    CensusBlockRepository censusBlockRepository;
//
//    public void testDistrict() {
//        CensusBlock censusBlock = censusBlockRepository.getById((long)1);
//        System.out.println(censusBlock.getGeoID20());
//    }

}
