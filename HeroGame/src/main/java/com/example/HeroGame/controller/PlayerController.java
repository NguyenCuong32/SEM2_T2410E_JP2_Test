package com.example.HeroGame.controller;

import com.example.HeroGame.model.Player;
import com.example.HeroGame.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerRepository repo;

    @PostMapping
    public Player add(@RequestBody Player p) {
        return repo.save(p);
    }

    @GetMapping
    public List<Player> getAll() {
        return repo.findAll();
    }

    @GetMapping("/top10")
    public List<Player> top10() {
        return repo.findTop10ByOrderByHighScoreDesc();
    }

    @GetMapping("/search")
    public List<Player> searchByName(@RequestParam String name) {
        return repo.findByPlayerNameContainingIgnoreCase(name);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        repo.deleteById(id);
    }
}
