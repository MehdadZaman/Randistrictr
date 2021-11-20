package MothBalls.Randistrictr.service;

import MothBalls.Randistrictr.model.CensusBlock;
import MothBalls.Randistrictr.object.Geometry;
import MothBalls.Randistrictr.object.MultiPolygon;
import MothBalls.Randistrictr.object.Polygon;
import MothBalls.Randistrictr.object.ShapeType;
import MothBalls.Randistrictr.repository.CensusBlockRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CensusBlockService {
    @Autowired
    CensusBlockRepository censusBlockRepository;

    public void voodooGeometry(){
    }
    
    public static Geometry stringToGeometry(String geoString) {
        Gson gson = new Gson();
        Polygon polygon = gson.fromJson(geoString, Polygon.class);
        Geometry geometry = new Geometry("Polygon", polygon.coordinates);
        return geometry;
    }
//
    public static String geometryToString(Geometry geo) {
        Gson gson = new Gson();
        return gson.toJson(geo);
    }

}
