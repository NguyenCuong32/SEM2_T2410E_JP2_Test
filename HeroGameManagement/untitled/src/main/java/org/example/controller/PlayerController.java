package org.example.controller;

import org.example.model.Player;
import org.example.model.National;
import org.example.service.PlayerService;
import org.example.service.NationalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/players") // Base URL cho các API liên quan đến người chơi
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private NationalService nationalService; // Cần để kiểm tra và liên kết National khi thêm Player

    // 2. Allow to show all players on the screen as Table1.
    // GET: Lấy tất cả người chơi
    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    // GET: Lấy người chơi theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Integer id) {
        Optional<Player> player = playerService.getPlayerById(id);
        return player.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 1. Allow add new players into the Playertable.
    // POST: Thêm người chơi mới
    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        // Đảm bảo rằng National được cung cấp (chỉ cần nationalId là đủ)
        if (player.getNational() == null || player.getNational().getNationalId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // Cần có National ID
        }

        // Kiểm tra xem National có tồn tại không
        Optional<National> existingNational = nationalService.getNationalById(player.getNational().getNationalId());
        if (existingNational.isPresent()) {
            player.setNational(existingNational.get()); // Gán đối tượng National đầy đủ
            Player savedPlayer = playerService.addPlayer(player);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPlayer);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // National không tìm thấy
        }
    }

    // 1. Remove a player.
    // DELETE: Xóa người chơi theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Integer id) {
        playerService.deletePlayer(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    // 3. Allow to find a player by name.
    // GET: Tìm người chơi theo tên (sử dụng RequestParam để truyền tên)
    @GetMapping("/search")
    public List<Player> searchPlayersByName(@RequestParam String name) {
        return playerService.findPlayersByName(name);
    }

    // 4. Allow to show top 10 players where having the most highscore.
    // GET: Lấy top 10 người chơi
    @GetMapping("/top10")
    public List<Player> getTop10Players() {
        return playerService.getTop10Players();
    }
}
