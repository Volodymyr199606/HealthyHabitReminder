
package org.com.services;

public class VegetableService extends BaseService {

    @Override
    public void logActivity() {
        String answer;
        while (true) {
            System.out.print("\nDid you eat any vegetables today? (yes/no): ");
            answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals("yes") || answer.equals("no")) {
                break;
            }
            System.out.println("Invalid input! Please enter 'yes' or 'no'.");
        }

        if (answer.equals("yes")) {
            System.out.println("Choose a vegetable: \n1. Onion 🧅 \n2. Carrot 🥕 \n3. Tomato 🍅");
            int choice = getUserChoice(1, 3);

            String vegetable = switch (choice) {
                case 1 -> "Onion";
                case 2 -> "Carrot";
                case 3 -> "Tomato";
                default -> "Unknown";
            };

            saveLog("INSERT INTO vegetable_log (vegetable_name, logged_at) VALUES (?, CURRENT_TIMESTAMP)", vegetable);
            String sql = "INSERT INTO vegetable_log (vegetable_name, logged_at) VALUES (?, CURRENT_TIMESTAMP)";
            System.out.println(getVegetableBenefits(vegetable));
        } else {
            System.out.println("You should eat vegetables daily for essential nutrients. 🥦");
        }
    }

    private String getVegetableBenefits(String vegetable) {
        return switch (vegetable) {
            case "Onion" -> "Onions provide Vitamin K for bone health. 🧅";
            case "Carrot" -> "Carrots provide Vitamin A for vision and immunity. 🥕";
            case "Tomato" -> "Tomatoes provide Vitamin K1 for blood clotting. 🍅";
            default -> "Unknown vegetable.";
        };
    }
}