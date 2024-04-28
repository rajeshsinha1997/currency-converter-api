package com.demo.cca.helpers;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * Utility class for working with environment-related operations.
 */
public class EnvironmentHelper {
    // private constructor to prevent instantiation
    private EnvironmentHelper() {
    }

    /**
     * Loads the dotenv file to retrieve environment variables.
     */
    public static void loadDotEnvFile() {
        // load dotenv file
        Dotenv dotenv = Dotenv.load();

        // add entries from dotenv file to system properties
        dotenv.entries().forEach(entry -> {
            // add entry to system property
            System.setProperty(CommonHelper.convertEnvironmentVariableNameToPropertyName(entry.getKey()),
                    entry.getValue());
        });
    }

    /**
     * Retrieves the value of the specified environment variable from system
     * environment variables or system properties.
     * 
     * @param key The name of the environment variable or property.
     * @return The value of the environment variable or property, or null if not
     *         found.
     */
    public static String resolveEnvironmentVariableOrPropertyValue(String key) {
        // retrieve value from the system environment variables
        String environmentVariableValue = System.getenv(key);

        // verify if a value was not found for the system environment variable
        if (environmentVariableValue == null) {
            // retrieve value from the system properties
            environmentVariableValue = System
                    .getProperty(CommonHelper.convertEnvironmentVariableNameToPropertyName(key));
        }

        // return environment variable value
        return environmentVariableValue == null ? environmentVariableValue : environmentVariableValue.trim();
    }
}
