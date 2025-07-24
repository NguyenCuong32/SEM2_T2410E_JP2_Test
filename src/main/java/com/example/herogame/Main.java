package com.example.herogame;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Thêm dữ liệu National trước (phải có ID để Player dùng)
        // Có thể tạo tay trong phpMyAdmin:
        // INSERT INTO National (NationalName) VALUES ('Vietnam'), ('USA'), ('Japan');

        // Thêm Player
        Player p1 = new Player(0, 1, "Player 1", 100, 2);
        Player p2 = new Player(0, 2, "Player 2", 1050, 10);
        Player p3 = new Player(0, 3, "Player 3", 200, 5);

        PlayerDAO.insertPlayer(p1);
        PlayerDAO.insertPlayer(p2);
        PlayerDAO.insertPlayer(p3);

        // Hiển thị toàn bộ player
        System.out.println("\n All Players:");
        List<Player> all = PlayerDAO.displayAll();
        for (Player p : all) {
            System.out.println(p);
        }

        // Tìm player theo tên
        System.out.println("\n Search by name 'Player 2':");
        List<Player> found = PlayerDAO.displayAllByPlayerName("Player 2");
        for (Player p : found) {
            System.out.println(p);
        }

        // Hiển thị top 10
        System.out.println("\n Top 10 Players by High Score:");
        List<Player> top = PlayerDAO.displayTop10();
        for (Player p : top) {
            System.out.println(p);
        }
        PlayerDAO.deletePlayer(4); // xóa player
        // Thêm National mới
        National vn = new National(0, "Thailand");
        NationalDAO.insertNational(vn);

        // Hiển thị danh sách National
        System.out.println("\n List of Nationals:");
        for (National n : NationalDAO.getAllNational()) {
            System.out.println(n);
        }

        // Xóa thử 1 National (ví dụ id = 4 nếu tồn tại)
        NationalDAO.deleteNational(4);
    }
}
