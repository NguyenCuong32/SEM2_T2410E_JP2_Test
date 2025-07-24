package Herogame.demo.Controller;

import Herogame.demo.Entity.National;
import Herogame.demo.Service.NationalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nationals")
public class NationalController {

    @Autowired
    private NationalService nationalService;


    @PostMapping
    public National addNational(@RequestBody National national) {
        return nationalService.insertNational(national);
    }


    @DeleteMapping("/{id}")
    public void deleteNational(@PathVariable int id) {
        nationalService.deleteNational(id);
    }


    @GetMapping
    public List<National> getAllNationals() {
        return nationalService.displayAllNationals();
    }


    @GetMapping("/{id}")
    public National getNationalById(@PathVariable int id) {
        return nationalService.getNationalById(id).orElse(null);
    }
}
