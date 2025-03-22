
package org.com.services;

public class WaterService extends BaseService {
    @Override
    public void logActivity() {
        int choice;
        while (true) {
            System.out.println("\nHow much water did you drink today?");
            System.out.println("1. 500mL - 1L\n2. 2L\n3. 3L\n4. Did not drink water today");
            choice = getUserChoice(1, 4);
            if (choice >= 1 && choice <= 4) {
                break;
            }
            System.out.println("Invalid choice! Please select a valid option.");
        }

        String waterIntake = switch (choice) {
            case 1 -> "1L";
            case 2 -> "2L";
            case 3 -> "3L";
            case 4 -> "No water";
            default -> "Unknown";
        };

        saveLog("INSERT INTO water_log (water_intake, logged_at) VALUES (?, CURRENT_TIMESTAMP)", waterIntake);
        String sql = "INSERT INTO water_log (water_intake, logged_at) VALUES (?, CURRENT_TIMESTAMP)";
        System.out.println(getWaterBenefits(choice));
    }

    private String getWaterBenefits(int choice) {
        return switch (choice) {
            case 1 -> "Drink more water, at least 2L for a good balance. 💧";
            case 2 -> "Good amount, but try to drink more if you're active. 🏋️‍♂️";
            case 3 -> "Perfect! Your body is well-hydrated. 💦";
            case 4 -> "You should drink water to stay hydrated. 🥤";
            default -> "Unknown choice.";
        };
    }
}