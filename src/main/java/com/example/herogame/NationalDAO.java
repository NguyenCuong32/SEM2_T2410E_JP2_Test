package com.example.herogame;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NationalDAO {

    // Thêm National
    public static void insertNational(National national) {
        String sql = "INSERT INTO National (NationalName) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, national.getNationalName());
            stmt.executeUpdate();
            System.out.println("National inserted!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa National
    public static void deleteNational(int nationalId) {
        String sql = "DELETE FROM National WHERE NationalId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, nationalId);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("🗑 National deleted!");
            } else {
                System.out.println("⚠️ National not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Hiển thị tất cả National
    public static List<National> getAllNational() {
        List<National> list = new ArrayList<>();
        String sql = "SELECT * FROM National";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                National n = new National(
                        rs.getInt("NationalId"),
                        rs.getString("NationalName")
                );
                list.add(n);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
