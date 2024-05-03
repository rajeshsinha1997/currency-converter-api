package com.demo.cca.helpers;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.extern.slf4j.Slf4j;

/**
 * Utility class for working with environment-related operations.
 */
@Slf4j
public class EnvironmentHelper {
    // private constructor to prevent instantiation
    private EnvironmentHelper() {
    }

    /**
     * Loads the dotenv file to retrieve environment variables.
     */
    public static void loadDotEnvFile() {
        // load dotenv file
        log.debug("loading dotenv file");
        Dotenv dotenv = Dotenv.load();

        // add entries from dotenv file to system properties
        log.debug("migrating entries from dotenv file to system properties");
        dotenv.entries().forEach(entry -> {
            // add entry to system property
            log.debug("migrating entry to system property for environment variable: " + entry.getKey());
            System.setProperty(CommonHelper.convertEnvironmentVariableNameToPropertyKey(entry.getKey()),
                    entry.getValue());
        });
        log.debug("successfully migrated entries from dotenv file to system properties");
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
        log.debug("retrieving value from environment variable: " + key);
        String environmentVariableValue = System.getenv(key);

        // verify if a value was not found for the system environment variable
        if (environmentVariableValue == null) {
            log.debug("provided environment variable does not have a value");

            // convert environment variable name to system property key
            log.debug("converting environment variable name to system property key: " + key);
            String systemPropertyKey = CommonHelper.convertEnvironmentVariableNameToPropertyKey(key);

            // retrieve value from the system properties
            log.debug("retrieving value from system properties for key: " + systemPropertyKey);
            environmentVariableValue = System
                    .getProperty(systemPropertyKey);

            // log retrieval status
            if (environmentVariableValue == null) {
                log.debug("could not find a value for the system property key: " + systemPropertyKey);
            } else {
                log.debug("successfully retrieved value for the system property key: " + systemPropertyKey);
            }
        }

        // return environment variable value
        return environmentVariableValue == null ? environmentVariableValue : environmentVariableValue.trim();
    }
}
