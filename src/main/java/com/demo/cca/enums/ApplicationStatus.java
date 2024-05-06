package com.demo.cca.enums;

import lombok.Getter;

/**
 * Enumeration representing the status of an application.
 */
@Getter
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
}
