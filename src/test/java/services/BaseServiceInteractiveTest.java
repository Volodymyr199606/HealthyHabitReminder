package services;

import org.com.database.DatabaseHelper;
import org.com.services.ExerciseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class BaseServiceInteractiveTest {
    private final ExerciseService exerciseService = new ExerciseService();

    @BeforeEach
    void setUp() {
        DatabaseHelper.createTable();
    }

    @Test
    void testSaveLog() {
        exerciseService.logActivity(); // Manually enter a response

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM exercise_log ORDER BY id DESC LIMIT 1")) {
            ResultSet rs = stmt.executeQuery();
            assertTrue(rs.next(), "Exercise log should exist.");
        } catch (SQLException e) {
            fail("Database query failed: " + e.getMessage());
        }
    }
}
