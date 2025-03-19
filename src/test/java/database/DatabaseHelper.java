package database;

import org.com.database.DatabaseHelper;
import org.junit.jupiter.api.Test;
import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseHelperTest {

    @Test
    void testDatabaseConnection() {
        try (Connection conn = DatabaseHelper.connect()) {
            assertNotNull(conn, "Database connection should not be null.");
        } catch (Exception e) {
            fail("Database connection failed: " + e.getMessage());
        }
    }

    @Test
    void testCreateTable() {
        assertDoesNotThrow(DatabaseHelper::createTable, "Table creation should not throw an exception.");
    }
}
