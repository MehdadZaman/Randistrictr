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

//
//    public void voodooGeometry(){
//
//        Gson
//    }
//
//    public static Geometry stringToGeometry(String rawGeometry) {
//        Geometry geo = new Geometry();
//
//        Gson gson = new Gson();
//
//        ShapeType shape = gson.fromJson(rawGeometry, ShapeType.class);
//        if (shape.type.equals("Polygon")) {
//             gson.fromJson(rawGeometry, Polygon.class)
//        } else if (shape.type.equals("MultiPolygon")) {
//             gson.fromJson(rawGeometry, MultiPolygon.class);
//        }
//
//
//
//        return geo;
//    }
//
//    public static String geometryToString(Geometry geo) {
//        Gson gson = new Gson();
//
//        return gson.toJson(geo);
//    }

}
