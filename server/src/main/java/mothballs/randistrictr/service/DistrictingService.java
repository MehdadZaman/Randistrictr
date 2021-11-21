package mothballs.randistrictr.service;

import mothballs.randistrictr.model.DistrictingPlan;
import mothballs.randistrictr.repository.DistrictingPlanRepository;
import mothballs.randistrictr.repository.DistrictingPlanStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictingService {
    @Autowired
    DistrictingPlanRepository districtingPlanRepository;
    @Autowired
    DistrictingPlanStatisticsRepository districtingPlanStatisticsRepository;
    public void testDistrict() {
        DistrictingPlan districtingPlan = districtingPlanRepository.getById((long)1);
        // System.out.println(districtingPlan.getRedistrictNumber());
    }

    public void addDistrictingPlan() {
//        DistrictingPlan dp = new DistrictingPlan();
//        DistrictingPlanStatistics dps = new DistrictingPlanStatistics();
//        dps.setRedistrictNumber(5);
//        dps.setNumOpportunities(10);
//        dp.setRedistrictNumber(5);
//        // dp.setDistrictingPlanStatistics(dps);
//        districtingPlanStatisticsRepository.saveAndFlush(dps);
//        districtingPlanRepository.saveAndFlush(dp);
//        List<DistrictingPlan> districtingPlans = districtingPlanRepository.findAll();
    }

}
