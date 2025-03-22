package org.com.database;


import java.sql.*;

public class DatabaseHelper {
    private static final String DB_NAME = "healthylife";
    private static final String URL_NO_DB = "jdbc:mysql://localhost:3306/";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
    private static final String USER = "root";
    private static final String PASSWORD = "Password_vova12345";

    // Connect to database (after it's created)
    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("❌ MySQL connection failed!", e);
        }
    }

    // Create the database if it doesn't exist
    public static void createDatabase() {
        try (Connection conn = DriverManager.getConnection(URL_NO_DB, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME);
            System.out.println("✅ Database `" + DB_NAME + "` is ready!");
        } catch (SQLException e) {
            throw new RuntimeException("❌ Failed to create database!", e);
        }
    }

    // Create necessary tables
    public static void createTables() {
        String userTable = """
        CREATE TABLE IF NOT EXISTS users (
            id INT AUTO_INCREMENT PRIMARY KEY,
            name VARCHAR(50),
            age INT,
            gender VARCHAR(10),
            activity_level VARCHAR(20)
        )
        """;

        String exerciseTable = """
        CREATE TABLE IF NOT EXISTS exercise_log (
            id INT AUTO_INCREMENT PRIMARY KEY,
            exercised BOOLEAN,
            logged_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        )
        """;

        String waterTable = """
        CREATE TABLE IF NOT EXISTS water_log (
            id INT AUTO_INCREMENT PRIMARY KEY,
            water_intake VARCHAR(50),
            logged_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        )
        """;

        String fruitTable = """
        CREATE TABLE IF NOT EXISTS fruit_log (
            id INT AUTO_INCREMENT PRIMARY KEY,
            fruit_name VARCHAR(50),
            logged_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        )
        """;

        String vegetableTable = """
        CREATE TABLE IF NOT EXISTS vegetable_log (
            id INT AUTO_INCREMENT PRIMARY KEY,
            vegetable_name VARCHAR(50),
            logged_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        )
        """;

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(userTable);
            stmt.execute(exerciseTable);
            stmt.execute(waterTable);
            stmt.execute(fruitTable);
            stmt.execute(vegetableTable);
            System.out.println("✅ Tables initialized successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
