package com.example.HeroGame.controller;

import com.example.HeroGame.entity.Player;
import com.example.HeroGame.repository.IPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private IPlayerRepository playerRepository;

    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removePlayer(@PathVariable Integer id) {
        playerRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @GetMapping("/search")
    public List<Player> findPlayersByName(@RequestParam String name) {
        return playerRepository.findByPlayerNameContainingIgnoreCase(name);
    }

    @GetMapping("/top10")
    public List<Player> getTop10Players() {
        return playerRepository.findTop10ByOrderByHighScoreDesc();
    }
}