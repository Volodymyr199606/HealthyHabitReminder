
package org.com.services;

public class ExerciseService extends BaseService {

    @Override
    public void logActivity() {
        String answer;
        while (true) {
            System.out.print("\nDid you do morning exercise? (yes/no): ");
            answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals("yes") || answer.equals("no")) {
                break;
            }
            System.out.println("Invalid input! Please enter 'yes' or 'no'.");
        }

        boolean exercised = answer.equals("yes");
        saveLog("INSERT INTO exercise_log (exercised, logged_at) VALUES (?, CURRENT_TIMESTAMP)", exercised);
        String sql = "INSERT INTO exercise_log (exercised, logged_at) VALUES (?, CURRENT_TIMESTAMP)";

        if (exercised) {
            System.out.println("Super! You will feel better and more active during the day. 💪");
        } else {
            System.out.println("You should do morning exercises as it boosts your energy for the whole day. 🏃");
        }
    }
}