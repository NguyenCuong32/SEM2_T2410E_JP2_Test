package com.example.demo.controller;

import com.example.demo.model.Player;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.dto.PlayerTableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/players")
@CrossOrigin
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepo;

    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        return playerRepo.save(player);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Integer id) {
        playerRepo.deleteById(id);
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerRepo.findAll();
    }

    @GetMapping("/search")
    public List<Player> findByName(@RequestParam String name) {
        return playerRepo.findByPlayerNameContainingIgnoreCase(name);
    }

    @GetMapping("/top10")
    public List<Player> getTop10Players() {
        return playerRepo.findTop10ByOrderByHighScoreDesc();
    }

    @GetMapping("/table")
    public List<PlayerTableDTO> getPlayerTable() {
        return playerRepo.findAll().stream()
                .map(player -> new PlayerTableDTO(
                        player.getPlayerId(),
                        player.getPlayerName(),
                        player.getHighScore(),
                        player.getLevel(),
                        player.getNational() != null ? player.getNational().getNationalName() : "Unknown"
                ))
                .collect(Collectors.toList());
    }
}
