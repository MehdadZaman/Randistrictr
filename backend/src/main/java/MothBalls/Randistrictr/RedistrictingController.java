package MothBalls.Randistrictr;

import MothBalls.Randistrictr.Person;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/redistricting")
@RestController
public class RedistrictingController {
//    @GetMapping

//    @PostMapping
//    public void printPost(@RequestBody Person p) {
//        System.out.println("p.getName()");
//    }

    @GetMapping
    public void getAllStudents() {
        System.out.println("YEET");
    }

//    @GetMapping
//    public void printPost() {
//        System.out.println(o);
//    }

}
