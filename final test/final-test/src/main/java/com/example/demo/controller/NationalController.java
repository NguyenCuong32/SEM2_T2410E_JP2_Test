package com.example.demo.controller;

import com.example.demo.model.National;
import com.example.demo.repository.NationalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nationals")
@CrossOrigin
public class NationalController {

    @Autowired
    private NationalRepository nationalRepo;

    @PostMapping
    public National addNational(@RequestBody National national) {
        return nationalRepo.save(national);
    }

    @DeleteMapping("/{id}")
    public void deleteNational(@PathVariable Integer id) {
        nationalRepo.deleteById(id);
    }

    @GetMapping
    public List<National> getAllNationals() {
        return nationalRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<National> getNationalById(@PathVariable Integer id) {
        return nationalRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
