package org.example.repository;

import org.example.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    // Các phương thức tùy chỉnh cho yêu cầu bài kiểm tra:

    // 3. Allow to find a player by name.
    // Spring Data JPA sẽ tự động tạo truy vấn dựa trên tên phương thức.
    // `ContainingIgnoreCase` giúp tìm kiếm không phân biệt chữ hoa/thường và tìm kiếm một phần tên.
    List<Player> findByPlayerNameContainingIgnoreCase(String playerName);

    // 4. Allow to show top 10 players where having the most highscore.
    // `findTop10ByOrderByHighScoreDesc` sẽ lấy 10 người chơi có HighScore cao nhất, sắp xếp giảm dần.
    List<Player> findTop10ByOrderByHighScoreDesc();
}
