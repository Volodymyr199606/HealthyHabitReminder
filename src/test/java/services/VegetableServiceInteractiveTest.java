package services;

import org.com.database.DatabaseHelper;
import org.com.services.VegetableService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

class VegetableServiceInteractiveTest {
    private final VegetableService vegetableService = new VegetableService();

    @BeforeEach
    void setUp() {
        try (Connection conn = DatabaseHelper.connect()) {
            assertNotNull(conn, "❌ Connection should not be null.");
            System.out.println("✅ Test DB connection successful.");
        } catch (SQLException e) {
            fail("❌ DB connection failed: " + e.getMessage());
        }
    }

    @Test
    void testLogVegetableIntake() {
        vegetableService.logActivity();

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM vegetable_log ORDER BY id DESC LIMIT 1")) {
            ResultSet rs = stmt.executeQuery();
            assertTrue(rs.next(), "Vegetable log should exist.");
        } catch (SQLException e) {
            fail("Database query failed: " + e.getMessage());
        }
    }
}
