package com.automationExcersise.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class CsvDataReader {
    private Map<String, String> data;

    public CsvDataReader(String filePath) {
        data = new HashMap<>();
        // Check if the file exists
        if (!Files.exists(Paths.get(filePath))) {
            throw new RuntimeException("CSV file not found at path: " + filePath);
        }
        /**
         * Read the file line by line and split each line on the first comma
         */
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#") || line.trim().isEmpty()) {
                    continue; // Skip comments and empty lines
                }
                String[] keyValue = line.split(",", 2); // Split only on the first comma
                if (keyValue.length == 2) {
                    data.put(keyValue[0].trim(), keyValue[1].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to get the data from the CSV file
     *
     * @param key
     * @return
     */
    public String getData(String key) {
        return data.get(key);
    }
}