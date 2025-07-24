package org.example.herogame;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {


    public static void insertPlayer(Player player) {
        String sql = "INSERT INTO Player (NationalId, PlayerName, HighScore, Level) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, player.getNationalId());
            stmt.setString(2, player.getPlayerName());
            stmt.setInt(3, player.getHighScore());
            stmt.setInt(4, player.getLevel());

            stmt.executeUpdate();
            System.out.println("✅ Player inserted!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void deletePlayer(int playerId) {
        String sql = "DELETE FROM Player WHERE PlayerId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, playerId);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("🗑 Player deleted!");
            } else {
                System.out.println("⚠️ Player not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static List<Player> displayAll() {
        List<Player> list = new ArrayList<>();
        String sql = "SELECT * FROM Player";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Player p = new Player(
                        rs.getInt("PlayerId"),
                        rs.getInt("NationalId"),
                        rs.getString("PlayerName"),
                        rs.getInt("HighScore"),
                        rs.getInt("Level")
                );
                list.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public static List<Player> displayAllByPlayerName(String name) {
        List<Player> list = new ArrayList<>();
        String sql = "SELECT * FROM Player WHERE PlayerName LIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Player p = new Player(
                        rs.getInt("PlayerId"),
                        rs.getInt("NationalId"),
                        rs.getString("PlayerName"),
                        rs.getInt("HighScore"),
                        rs.getInt("Level")
                );
                list.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public static List<Player> displayTop10() {
        List<Player> list = new ArrayList<>();
        String sql = "SELECT * FROM Player ORDER BY HighScore DESC LIMIT 10";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Player p = new Player(
                        rs.getInt("PlayerId"),
                        rs.getInt("NationalId"),
                        rs.getString("PlayerName"),
                        rs.getInt("HighScore"),
                        rs.getInt("Level")
                );
                list.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
