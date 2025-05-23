package com.graphql.test.config;

import java.io.InputStream; // Added import
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private static final Properties properties = new Properties();
    private static ConfigManager instance;

    private ConfigManager() {
        try (InputStream input = ConfigManager.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                // Try with a leading slash if the above fails, sometimes classloaders differ
                try (InputStream inputWithSlash = ConfigManager.class.getClassLoader().getResourceAsStream("/config.properties")) {
                    if (inputWithSlash == null) {
                        throw new IOException("Unable to find config.properties in classpath (tried with and without leading slash)");
                    }
                    properties.load(inputWithSlash);
                }
            } else {
                properties.load(input);
            }
        } catch (IOException e) {
            // Log the error or print stack trace for better debugging if it still fails
            // e.printStackTrace(); 
            throw new RuntimeException("Failed to load config.properties from classpath", e);
        }
    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getBaseUrl() {
        return getProperty("base.url");
    }

    public String getApiKey() {
        return getProperty("api.key");
    }
} 