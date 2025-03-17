
package org.com.service;

import org.com.database.DatabaseHelper;
import org.com.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserService {
    public void addUser(User user) {
        String sql = "INSERT INTO users (name, age, gender, activity_level) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setInt(2, user.getAge());
            stmt.setString(3, user.getGender());
            stmt.setString(4, user.getActivityLevel());
            stmt.executeUpdate();
            System.out.println("User data saved to the database successfully! ✅");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error saving user to database! ❌");
        }
    }
}