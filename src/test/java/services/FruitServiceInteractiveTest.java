package services;

import org.com.database.DatabaseHelper;
import org.com.services.FruitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

class FruitServiceInteractiveTest {
    private final FruitService fruitService = new FruitService();

    @BeforeEach
    void setUp() {
        DatabaseHelper.createTables();
    }

    @Test
    void testLogFruitIntake() {
        fruitService.logActivity();

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM fruit_log ORDER BY id DESC LIMIT 1")) {
            ResultSet rs = stmt.executeQuery();
            assertTrue(rs.next(), "Fruit log should exist.");
        } catch (SQLException e) {
            fail("Database query failed: " + e.getMessage());
        }
    }
}
