package MothBalls.Randistrictr.service;

import MothBalls.Randistrictr.model.District;
import MothBalls.Randistrictr.model.Population;
import MothBalls.Randistrictr.repository.DistrictRepository;
import MothBalls.Randistrictr.repository.PopulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {
    @Autowired
    DistrictRepository districtRepository;

    @Autowired
    PopulationRepository populationRepository;

    public Population getPopulation(String id) {
        // System.out.println(populationRepository.findAllByGeoID20Containing("24"));
        // return populationRepository.findByGeoID20(id);
        return populationRepository.findByGeoID20(id);
    }

    public List<Population> getAllPopulations() {
        // System.out.println(populationRepository.findAllByGeoID20Containing("24"));
        return populationRepository.findAllByGeoID20Containing("24");
    }

    public void testDistrict() {
       District district = districtRepository.getById((long)1);
       System.out.println(district.getId());
    }


}
