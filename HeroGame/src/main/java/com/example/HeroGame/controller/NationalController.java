package com.example.HeroGame.controller;

import com.example.HeroGame.entity.National;
import com.example.HeroGame.repository.INationalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nationals")
public class NationalController {

    @Autowired
    private INationalRepository nationalRepository;

    @GetMapping
    public List<National> getAllNationals() {
        return nationalRepository.findAll();
    }

    @PostMapping
    public National addNational(@RequestBody National national) {
        return nationalRepository.save(national);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeNational(@PathVariable Integer id) {
        nationalRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}