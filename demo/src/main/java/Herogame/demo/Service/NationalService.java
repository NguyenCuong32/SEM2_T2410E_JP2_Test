package Herogame.demo.Service;

import Herogame.demo.Entity.National;
import Herogame.demo.Resposirity.NationalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NationalService {

    @Autowired
    private NationalRepository nationalRepository;


    public National insertNational(National national) {
        return nationalRepository.save(national);
    }


    public void deleteNational(int nationalId) {
        nationalRepository.deleteById(nationalId);
    }


    public List<National> displayAllNationals() {
        return nationalRepository.findAll();
    }


    public Optional<National> getNationalById(int id) {
        return nationalRepository.findById(id);
    }
}


