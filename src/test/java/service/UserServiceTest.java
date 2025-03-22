package service;

import org.com.database.DatabaseHelper;
import org.com.model.User;
import org.com.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private final UserService userService = new UserService();

    @BeforeEach
    void setUp() {

    }

    @Test
    void testAddUser() {
        User user = new User("Alice", 25, "female", "Active");
        userService.addUser(user);

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE name = ?")) {
            stmt.setString(1, "Alice");
            ResultSet rs = stmt.executeQuery();
            assertTrue(rs.next(), "User should exist in the database.");
            assertEquals("female", rs.getString("gender"), "Gender should be 'female'.");
        } catch (SQLException e) {
            fail("Database query failed: " + e.getMessage());
        }
    }
}
