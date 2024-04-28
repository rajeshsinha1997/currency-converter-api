package com.demo.cca.enums;

/**
 * Enumeration representing the status of an application.
 */
public enum ApplicationStatus {
    // application is up
    UP("up"),

    // application is down
    DOWN("down");

    private final String enumValue;

    /**
     * Constructor for ApplicationStatus enum.
     * 
     * @param enumValue The value associated with the enum constant.
     */
    ApplicationStatus(String enumValue) {
        this.enumValue = enumValue;
    }

    /**
     * Retrieves the value associated with the enum constant.
     * 
     * @return The value associated with the enum constant.
     */
    public String getEnumValue() {
        // return the value associated with the enum
        return this.enumValue;
    }
}
