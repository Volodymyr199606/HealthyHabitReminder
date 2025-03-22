package services;

import org.com.database.DatabaseHelper;
import org.com.services.WaterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

class WaterServiceInteractiveTest {
    private final WaterService waterService = new WaterService();

    @BeforeEach
    void setUp() {
        try (Connection conn = DatabaseHelper.connect()) {
            assertNotNull(conn, "❌ DB connection failed.");
        } catch (SQLException e) {
            fail("❌ DB connection failed: " + e.getMessage());
        }
    }

    @Test
    void testLogWaterIntake() {
        waterService.logActivity();

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM water_log ORDER BY id DESC LIMIT 1")) {
            ResultSet rs = stmt.executeQuery();
            assertTrue(rs.next(), "Water log should exist.");
        } catch (SQLException e) {
            fail("Database query failed: " + e.getMessage());
        }
    }
}
