package org.exampleherogame.dao;

import com.example.herogame.db.DbConnection;
import com.example.herogame.model.National;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NationalDAO {

    public List<National> getAllNationals() {
        List<National> nationals = new ArrayList<>();
        String sql = "SELECT * FROM National ORDER BY NationalName";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                nationals.add(new National(rs.getInt("NationalId"), rs.getString("NationalName")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nationals;
    }
}
