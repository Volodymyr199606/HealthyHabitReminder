package org.com.controller;

import org.com.model.User;
import org.com.service.UserService;
import org.com.services.*;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UserController {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserService userService = new UserService();

    private static final String NAME_REGEX = "^[A-Za-z]+$";
    private static final String AGE_REGEX = "^\\d+$";
    private static final String GENDER_REGEX = "^(male|female)$";
    private static final String ACTIVITY_REGEX = "^(sedentary|active)$";

    private static final Loggable[] services = {
            new ExerciseService(),
            new WaterService(),
            new FruitService(),
            new VegetableService()
    };

    public static void startApplication() {
        System.out.println("Welcome to Healthy Life Reminder!\n");

        String name = getValidInput("Enter your name (only letters): ", NAME_REGEX, "Invalid input! Name must contain only letters.");
        String age = getValidInput("Enter your age (only digits): ", AGE_REGEX, "Invalid input! Age must be a number.");
        String gender = getValidInput("Enter your gender (male/female): ", GENDER_REGEX, "Invalid input! Gender must be 'male' or 'female'.");
        String activityLevel = getValidInput("Enter your activity level (sedentary/active): ", ACTIVITY_REGEX, "Invalid input! Activity level must be 'sedentary' or 'active'.");


        int userAge = Integer.parseInt(age);


        User user = new User(name, userAge, gender, activityLevel);
        userService.addUser(user);

        System.out.println("\nUser registered successfully! 🎉 Now let's log your daily health activities.\n");


        while (true) {
            System.out.println("\nPlease choose an activity to log:");
            System.out.println("1. Log Exercise 🏋️");
            System.out.println("2. Log Water Intake 💧");
            System.out.println("3. Log Fruit Consumption 🍏🍌");
            System.out.println("4. Log Vegetable Consumption 🥦🥕");
            System.out.println("5. Exit 🚪");

            System.out.print("Enter your choice (1-5): ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    services[0].logActivity();
                    break;
                case "2":
                    services[1].logActivity();
                    break;
                case "3":
                    services[2].logActivity();
                    break;
                case "4":
                    services[3].logActivity();
                    break;
                case "5":
                    System.out.println("\nThank you for using Healthy Life Reminder! Stay healthy! 😊");
                    return;
                default:
                    System.out.println("❌ Invalid choice! Please enter a number between 1 and 5.");
            }
        }
    }

    private static String getValidInput(String prompt, String regex, String errorMessage) {
        String input;
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (pattern.matcher(input).matches()) {
                return input;
            }
            System.out.println(errorMessage);
        }
    }
}