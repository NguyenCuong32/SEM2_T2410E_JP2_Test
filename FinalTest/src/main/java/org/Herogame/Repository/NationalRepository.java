package org.Herogame.Repository;



import org.Herogame.connect.ConnectDB;
import org.Herogame.entity.National;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NationalRepository {

    public void addNational(National n) {
        String sql = "INSERT INTO National (NationalName) VALUES (?)";
        try (Connection conn = ConnectDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, n.getNationalName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeNational(int id) {
        String sql = "DELETE FROM National WHERE NationalId = ?";
        try (Connection conn = ConnectDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<National> getAllNationals() {
        List<National> list = new ArrayList<>();
        String sql = "SELECT * FROM National";
        try (Connection conn = ConnectDB.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                National n = new National(rs.getInt("NationalId"), rs.getString("NationalName"));
                list.add(n);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
