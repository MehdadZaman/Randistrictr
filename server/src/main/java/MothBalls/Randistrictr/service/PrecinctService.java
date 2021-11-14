package MothBalls.Randistrictr.service;

import MothBalls.Randistrictr.model.Precinct;
import MothBalls.Randistrictr.repository.PrecinctRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrecinctService {

    @Autowired
    private PrecinctRepository precinctRepository;

    public List<Precinct> list() {
        return precinctRepository.findAll();
    }
}
