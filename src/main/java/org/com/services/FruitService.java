
package org.com.services;

public class FruitService extends BaseService {

    @Override
    public void logActivity() {
        String answer;
        while (true) {
            System.out.print("\nDid you eat any fruits today? (yes/no): ");
            answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals("yes") || answer.equals("no")) {
                break;
            }
            System.out.println("Invalid input! Please enter 'yes' or 'no'.");
        }

        if (answer.equals("yes")) {
            System.out.println("Choose a fruit: \n1. Apple 🍏 \n2. Banana 🍌 \n3. Orange 🍊");
            int choice = getUserChoice(1, 3);

            String fruit = switch (choice) {
                case 1 -> "Apple";
                case 2 -> "Banana";
                case 3 -> "Orange";
                default -> "Unknown";
            };

            saveLog("INSERT INTO fruit_log (fruit_name, logged_at) VALUES (?, datetime('now'))", fruit);
            System.out.println(getFruitBenefits(fruit));
        } else {
            System.out.println("You should eat fruits daily for better health. 🥗");
        }
    }

    private String getFruitBenefits(String fruit) {
        return switch (fruit) {
            case "Apple" -> "Great! Apples provide Vitamin C for immunity. 🍏";
            case "Banana" -> "Great! Bananas provide Vitamin B6 for brain function. 🍌";
            case "Orange" -> "Great! Oranges provide Vitamin C for skin and immunity. 🍊";
            default -> "Unknown fruit.";
        };
    }
}