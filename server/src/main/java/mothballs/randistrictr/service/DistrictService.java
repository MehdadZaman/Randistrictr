package mothballs.randistrictr.service;

import mothballs.randistrictr.model.*;
import mothballs.randistrictr.object.Basis;
import mothballs.randistrictr.repository.*;
import org.hibernate.Hibernate;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileReader;
import java.util.*;

@Service
public class DistrictService {
    final String ENACTED_DISTRICTING_PLAN = "00";

    @Autowired
    DistrictRepository districtRepository;

    @Autowired
    PopulationRepository populationRepository;

    @Autowired
    StateRepository stateRepository;

    @Autowired
    CensusBlockRepository censusBlockRepository;

    @Autowired
    DissolvingService dissolvingService;

    @Autowired
    DistrictingPlanStatisticsRepository districtingPlanStatisticsRepository;

    @Autowired
    BoxAndWhiskerRepository boxAndWhiskerRepository;

    private State currentState;
    private DistrictingPlan currentDistrictingPlan;
    private boolean hasInitializedCensusBlocks;

    public Population getPopulation(String id) {
        return populationRepository.findByGeoID20(id);
    }

    public void selectState(String state) {
        hasInitializedCensusBlocks = false;
        this.currentState = stateRepository.findStateByState(state);
        Hibernate.initialize(this.currentState.getDistrictingPlans());
    }

    public JSONObject getEnactedDistricting() {
        return readEnactedDistrictingPlan(currentState.getState());
    }

    public List<DistrictingPlanStatistics> getAllDistrictingPlanStatistics() {
        List<DistrictingPlanStatistics> districtingPlanStatistics = new ArrayList<>();
        for(DistrictingPlan districtingPlan : currentState.getDistrictingPlans()) {
            districtingPlanStatistics.add(districtingPlan.getDistrictingPlanStatistics());
        }
        return districtingPlanStatistics;
    }

    public JSONObject getDistrictingPlan(int districtPlanNumber) {
        if(!hasInitializedCensusBlocks){
            this.currentDistrictingPlan = stateRepository.findStateByState(this.currentState.getState()).getDistrictingPlans().get(districtPlanNumber);
            hasInitializedCensusBlocks = true;
        }
        return dissolvingService.getDistrictingJSON(this.currentDistrictingPlan);
    }

    public DistrictingPlanStatistics getDistrictingPlanStatistics() {
        return currentDistrictingPlan.getDistrictingPlanStatistics();
    }

    public DistrictingPlanStatistics getEnactedDistrictingPlanStatistics() {
        return districtingPlanStatisticsRepository.findById(currentState.getStateNumber() + ENACTED_DISTRICTING_PLAN);
    }

    public DistrictingPlan getCurrentDistrictingPlan() {
        return currentDistrictingPlan;
    }

    public void setCurrentDistrictingPlan(DistrictingPlan currentDistrictingPlan) {
        this.currentDistrictingPlan = currentDistrictingPlan;
    }


    public JSONObject readEnactedDistrictingPlan(String stateName) {
        try {
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader("src/main/java/mothballs/randistrictr/constants/" + stateName.toLowerCase() + "_congressional_districts.json");
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void resetState() {
        this.hasInitializedCensusBlocks = false;
        this.currentState = null;
        this.currentDistrictingPlan = null;
    }

    public JSONObject getBoxAndWhisker(Basis basis) {
        return getBoxAndWhiskerJSONData(boxAndWhiskerRepository.findByBasisAndState(basis, currentState.getStateNumber()));
    }

    public JSONObject getBoxAndWhiskerJSONData(BoxAndWhisker boxAndWhisker) {

        List<BoxPlot> allBoxes = boxAndWhisker.getBoxes();
        Collections.sort(allBoxes, (a, b) -> a.getWhiskerPosition() - b.getWhiskerPosition());

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type", "boxAndWhisker");
        jsonObject.put("yValueFormatString", "#,##0.# \\\"People\\");

        JSONArray boxPlotArray = new JSONArray();

        for(BoxPlot boxPlot : allBoxes) {
            JSONObject box = new JSONObject();
            box.put("label", boxPlot.getWhiskerPosition());

            JSONArray numbers = new JSONArray();
            numbers.add(boxPlot.getMinimum());
            numbers.add(boxPlot.getFirstQuartile());
            numbers.add(boxPlot.getMedian());
            numbers.add(boxPlot.getThirdQuartile());
            numbers.add(boxPlot.getMaximum());
            box.put("y", numbers);

            boxPlotArray.add(box);
        }

        jsonObject.put("dataPoints", boxPlotArray);

        // Overarching JSON object
        JSONObject componentObject = new JSONObject();
        componentObject.put("theme", "light2");
        componentObject.put("title", new JSONObject().put("text", "Ensemble of " + boxAndWhisker.getBasis() + " Population"));
        componentObject.put("axisY", new JSONObject().put("title",  "Population"));
        componentObject.put("data", new JSONArray().add(jsonObject));

        return componentObject;
    }
}
