package org.com.controller;

import org.com.service.UserService;
import org.com.services.*;
import java.util.Scanner;

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

    }
}


