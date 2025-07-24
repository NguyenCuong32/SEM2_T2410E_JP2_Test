package com.example.finaltest.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finaltest.entity.Player;
import com.example.finaltest.service.PlayerDTO;
import com.example.finaltest.service.PlayerService;

@RestController
@RequestMapping("/api/player")
public class PlayerController {
    @Autowired
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/all")
    public List<PlayerDTO> displayAll() {
        return playerService.findAll()
                .stream()
                .map(p -> new PlayerDTO(
                        p.getPlayerid(),
                        p.getPlayername(),
                        p.getHighscore(),
                        p.getLevel(),
                        p.getNational() != null ? p.getNational().getNationalname() : "Unknown"))
                .collect(Collectors.toList());
    }

    @PostMapping("/insert")
    public Player insertPlayer(@RequestBody Player player) {
        return playerService.save(player);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePlayer(@PathVariable int id) {
        playerService.deleteById(id);
        return "Deleted player with ID: " + id;
    }

    @GetMapping("/by-name")
    public List<Player> displayAllByPlayerName() {
        return playerService.findAll()
                .stream()
                .sorted((p1, p2) -> p1.getPlayername().compareToIgnoreCase(p2.getPlayername()))
                .collect(Collectors.toList());
    }

    @GetMapping("/top10")
    public List<Player> displayTop10() {
        return playerService.findAll()
                .stream()
                .sorted((p1, p2) -> Integer.compare(p2.getHighscore(), p1.getHighscore()))
                .limit(10)
                .collect(Collectors.toList());
    }
}
