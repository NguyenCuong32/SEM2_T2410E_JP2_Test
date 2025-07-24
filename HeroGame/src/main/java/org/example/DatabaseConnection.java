package org.example.herogame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/HeroGame";
            String user = "root";
            String password = "";

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to MySQL!");
        } catch (SQLException e) {
            System.out.println("Failed to connect MySQL:");
            e.printStackTrace();
        }

        return conn;
    }
}