package org.Herogame;


import org.Herogame.Repository.NationalRepository;
import org.Herogame.Repository.PlayerRepository;
import org.Herogame.entity.National;
import org.Herogame.entity.Player;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PlayerRepository playerRepo = new PlayerRepository();
        NationalRepository nationalRepo = new NationalRepository();

        // 1. Thêm quốc tịch
        National vn = new National("Vietnam");
        National us = new National("USA");
        National jp = new National("Japan");
        nationalRepo.addNational(vn);
        nationalRepo.addNational(us);
        nationalRepo.addNational(jp);

        // 2. Thêm người chơi
        playerRepo.addPlayer(new Player(1, "Player 1", 100, 2));
        playerRepo.addPlayer(new Player(2, "Player 2", 1050, 10));
        playerRepo.addPlayer(new Player(3, "Player 3", 200, 5));

        // 3. Hiển thị tất cả người chơi
        System.out.println("Danh sách tất cả người chơi:");
        List<Player> allPlayers = playerRepo.getAllPlayers();
        for (Player p : allPlayers) {
            System.out.printf("ID: %d | Name: %s | Score: %d | Level: %d | NationalId: %d\n",
                    p.getPlayerId(), p.getPlayerName(), p.getHighScore(), p.getLevel(), p.getNationalId());
        }

        // 4. Tìm người chơi theo tên
        System.out.println("\nTìm người chơi tên chứa '2':");
        List<Player> found = playerRepo.searchByName("2");
        for (Player p : found) {
            System.out.printf("Name: %s | Score: %d\n", p.getPlayerName(), p.getHighScore());
        }

        // 5. Hiển thị top 10 người chơi
        System.out.println("\nTop 10 người chơi có điểm cao nhất:");
        List<Player> top10 = playerRepo.getTop10Players();
        for (Player p : top10) {
            System.out.printf("Name: %s | Score: %d\n", p.getPlayerName(), p.getHighScore());
        }

        // 6. Xoá 1 người chơi (ví dụ PlayerId = 1)
        playerRepo.removePlayer(1);
        System.out.println("\nĐã xoá người chơi có ID = 1");

        // 7. Xoá 1 quốc tịch (ví dụ NationalId = 1)
        nationalRepo.removeNational(1);
        System.out.println("Đã xoá quốc tịch có ID = 1");
    }
}

