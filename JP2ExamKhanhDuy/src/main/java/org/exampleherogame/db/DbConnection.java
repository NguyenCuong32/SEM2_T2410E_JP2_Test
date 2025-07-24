package org.exampleherogame.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/HeroGame";
    private static final String USER = "root"; // <-- CHANGE TO YOUR MYSQL USERNAME
    private static final String PASSWORD = "your_password"; // <-- CHANGE TO YOUR MYSQL PASSWORD

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Failed to connect to the database!");
        }
        return connection;
    }
}