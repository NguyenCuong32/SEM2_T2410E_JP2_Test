package com.example.finaltest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finaltest.entity.National;
import com.example.finaltest.service.NationalService;

@RestController
@RequestMapping("/api/national")
public class NationalController {
    @Autowired
    private final NationalService playerService;
    @GetMapping
    public ResponseEntity<List<National>> getAll() {
        List<National> list = playerService.findAll();
        System.out.println("Retrieved all players: " + list.size() + " items");
        return ResponseEntity.ok(list);
    }
    public NationalController(NationalService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/insert")
    public National insertPlayer(@RequestBody National player) {
        return playerService.save(player);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePlayer(@PathVariable int id) {
        playerService.deleteById(id);
        return "Deleted nation with ID: " + id;
    }
}
