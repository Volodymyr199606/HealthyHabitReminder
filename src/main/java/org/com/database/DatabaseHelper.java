
package org.com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHelper {
    private static final String URL = "jdbc:sqlite:HealthyLifeReminder.db";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            throw new RuntimeException("Database connection failed! ❌", e);
        }
    }

    public static void createTable() {
        String userTable = "CREATE TABLE IF NOT EXISTS users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "age INTEGER, " +
                "gender TEXT, " +
                "activity_level TEXT)";

        String vegetableTable = "CREATE TABLE IF NOT EXISTS vegetable_log (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "vegetable_name TEXT, " +
                "logged_at DATETIME)";

        String exerciseTable = "CREATE TABLE IF NOT EXISTS exercise_log (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "exercised BOOLEAN, " +
                "logged_at DATETIME)";

        String fruitTable = "CREATE TABLE IF NOT EXISTS fruit_log (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "fruit_name TEXT, " +
                "logged_at DATETIME)";

        String waterTable = "CREATE TABLE IF NOT EXISTS water_log (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "water_intake TEXT, " +
                "logged_at DATETIME)";

        try (Connection conn = connect();
             PreparedStatement userStmt = conn.prepareStatement(userTable);
             PreparedStatement vegStmt = conn.prepareStatement(vegetableTable);
             PreparedStatement exerciseStmt = conn.prepareStatement(exerciseTable);
             PreparedStatement fruitStmt = conn.prepareStatement(fruitTable);
             PreparedStatement waterStmt = conn.prepareStatement(waterTable)) {
            userStmt.execute();
            vegStmt.execute();
            exerciseStmt.execute();
            fruitStmt.execute();
            waterStmt.execute();
            System.out.println("Database initialized successfully! ✅");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}