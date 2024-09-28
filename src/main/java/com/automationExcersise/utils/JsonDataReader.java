package com.automationExcersise.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.*;

public class JsonDataReader {

    private JSONObject json;

    /**
     * Constructor to read the JSON file
     * @param testName
     */
    public JsonDataReader(String testName) {
        String filePath = "src/main/resources/data/" + testName + ".json";
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
            this.json = new JSONObject(jsonContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getData(String dataKey) {
        if (json != null && json.has(dataKey)) {
            return json.getString(dataKey);
        }
        return null;
    }
}

