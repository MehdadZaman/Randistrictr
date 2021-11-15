package MothBalls.Randistrictr.service;

import MothBalls.Randistrictr.Model.District;
import MothBalls.Randistrictr.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {
    @Autowired
    DistrictRepository districtRepository;

    public void testDistrict() {
       District district = districtRepository.getById((long)1);
       System.out.println(district.getId());
    }


}
