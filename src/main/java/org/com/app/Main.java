
package org.com.app;

import org.com.controller.UserController;
import org.com.database.DatabaseHelper;

public class Main {
    public static void main(String[] args) {
        DatabaseHelper.createTable();
        UserController.startApplication();
    }
}