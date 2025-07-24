package org.exampleherogame.dao;

import com.example.herogame.db.DbConnection;
import com.example.herogame.model.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {

    private Player extractPlayerFromResultSet(ResultSet rs) throws SQLException {
        return new Player(
                rs.getInt("PlayerId"),
                rs.getString("PlayerName"),
                rs.getInt("HighScore"),
                rs.getInt("Level"),
                rs.getInt("NationalId"),
                rs.getString("NationalName")
        );
    }

    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        String sql = "SELECT p.*, n.NationalName FROM Player p " +
                "LEFT JOIN National n ON p.NationalId = n.NationalId ORDER BY p.PlayerId";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                players.add(extractPlayerFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    public boolean insertPlayer(Player player) {
        String sql = "INSERT INTO Player(PlayerName, HighScore, Level, NationalId) VALUES(?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, player.getPlayerName());
            pstmt.setInt(2, player.getHighScore());
            pstmt.setInt(3, player.getLevel());
            pstmt.setInt(4, player.getNationalId());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletePlayer(int playerId) {
        String sql = "DELETE FROM Player WHERE PlayerId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, playerId);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Player> findPlayersByName(String name) {
        List<Player> players = new ArrayList<>();
        String sql = "SELECT p.*, n.NationalName FROM Player p " +
                "LEFT JOIN National n ON p.NationalId = n.NationalId " +
                "WHERE p.PlayerName LIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + name + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    players.add(extractPlayerFromResultSet(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    public List<Player> getTop10Players() {
        List<Player> players = new ArrayList<>();
        String sql = "SELECT p.*, n.NationalName FROM Player p " +
                "LEFT JOIN National n ON p.NationalId = n.NationalId " +
                "ORDER BY p.HighScore DESC LIMIT 10";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                players.add(extractPlayerFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }
}
