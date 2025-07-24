package com.example.HeroGame.controller;

import com.example.HeroGame.entity.National;
import com.example.HeroGame.repository.NationalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nationals")
public class NationalController {

    @Autowired
    private NationalRepository nationalRepository;

    @PostMapping("/add")
    public National addNational(@RequestBody National national) {
        return nationalRepository.save(national);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNational(@PathVariable int id) {
        nationalRepository.deleteById(id);
    }

    @GetMapping("/all")
    public List<National> getAllNationals() {
        return nationalRepository.findAll();
    }
}
