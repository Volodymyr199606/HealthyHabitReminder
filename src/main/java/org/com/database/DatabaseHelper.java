package org.com.database;


import java.sql.*;

public class DatabaseHelper {
    private static final String DB_NAME = "healthyLife";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME + "?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "Password_vova12345";
    private static final String URL_NO_DB = "jdbc:mysql://localhost:3306/?useSSL=false&serverTimezone=UTC";


    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("❌ MySQL connection failed!", e);
        }
    }


    public static void createDatabase() {
        try (Connection conn = DriverManager.getConnection(URL_NO_DB, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME);
            System.out.println();
            System.out.println("✅ Database `" + DB_NAME + "` is ready!");
        } catch (SQLException e) {
            throw new RuntimeException("❌ Failed to create database!", e);
        }
    }

    public static void testConnection() {
        try (Connection conn = connect()) {
            System.out.println("✅ Connected to MySQL database!");
        } catch (SQLException e) {
            System.err.println("❌ Failed to connect to the database.");
            e.printStackTrace();
        }
    }
}
