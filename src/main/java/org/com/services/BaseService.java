package org.com.services;

import org.com.database.DatabaseHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public abstract class BaseService  {
    protected final Scanner scanner = new Scanner(System.in);

    protected void saveLog(String sql, Object... params) {
        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            stmt.executeUpdate();
            System.out.println("Activity recorded successfully! ✅");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error saving activity data! ❌");
        }
    }

    protected int getUserChoice(int min, int max) {
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice >= min && choice <= max) {
                    return choice;
                }
                System.out.println("Invalid choice! Please select a valid option.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }
}