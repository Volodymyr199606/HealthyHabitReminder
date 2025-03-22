package database;

import org.com.database.DatabaseHelper;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseHelperTest {

    @Test
    void testConnection() {
        try (Connection conn = DatabaseHelper.connect()) {
            assertNotNull(conn, "❌ Connection should not be null");
            System.out.println("✅ DB connection test passed.");
        } catch (SQLException e) {
            fail("❌ DB connection failed: " + e.getMessage());
        }
    }
}
