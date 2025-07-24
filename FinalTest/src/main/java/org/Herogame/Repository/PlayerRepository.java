package org.Herogame.Repository;

import org.Herogame.connect.ConnectDB;
import org.Herogame.entity.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerRepository {

    public void addPlayer(Player p) {
        String sql = "INSERT INTO Player (NationalId, PlayerName, HighScore, Level) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, p.getNationalId());
            ps.setString(2, p.getPlayerName());
            ps.setInt(3, p.getHighScore());
            ps.setInt(4, p.getLevel());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removePlayer(int id) {
        String sql = "DELETE FROM Player WHERE PlayerId = ?";
        try (Connection conn = ConnectDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Player> getAllPlayers() {
        List<Player> list = new ArrayList<>();
        String sql = "SELECT * FROM Player";
        try (Connection conn = ConnectDB.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
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

    public List<Player> searchByName(String name) {
        List<Player> list = new ArrayList<>();
        String sql = "SELECT * FROM Player WHERE PlayerName LIKE ?";
        try (Connection conn = ConnectDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
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

    public List<Player> getTop10Players() {
        List<Player> list = new ArrayList<>();
        String sql = "SELECT * FROM Player ORDER BY HighScore DESC LIMIT 10";
        try (Connection conn = ConnectDB.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
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