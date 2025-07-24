package Herogame.demo.Controller;

import Herogame.demo.Entity.Player;
import Herogame.demo.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;


    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        return playerService.insertPlayer(player);
    }


    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable int id) {
        playerService.deletePlayer(id);
    }


    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.displayAllPlayers();
    }


    @GetMapping("/search")
    public List<Player> findPlayerByName(@RequestParam String name) {
        return playerService.displayAllByPlayerName(name);
    }


    @GetMapping("/top10")
    public List<Player> getTop10Players() {
        return playerService.displayTop10Players();
    }
}

