package org.com.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class DataLogger {
    private static final String FILE_PATH = "user_data_log.txt";

    public static void log(String entry) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write(LocalDateTime.now() + " - " + entry + "\n");
        } catch (IOException e) {
            System.err.println("❌ Failed to write user log: " + e.getMessage());
        }
    }
}
