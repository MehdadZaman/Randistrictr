package MothBalls.Randistrictr.service;

import MothBalls.Randistrictr.model.District;
import MothBalls.Randistrictr.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictService {
    @Autowired
    DistrictRepository districtRepository;

    public void testDistrict() {
       District district = districtRepository.getById((long)1);
       System.out.println(district.getId());
    }


}
