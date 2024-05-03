package com.demo.cca.dto.response;

import java.util.List;

import com.demo.cca.enums.ApplicationStatus;
import com.demo.cca.interfaces.IResponseData;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

/**
 * Represents the response data structure for health information of an
 * application.
 */
@ToString
public class HealthResponseDTO implements IResponseData {
    // The name of the application
    @JsonProperty("application-name")
    private String applicationName;

    // The version of the application
    @JsonProperty("application-version")
    private String applicationVersion;

    // The uptime of the application
    @JsonProperty("application-uptime")
    private String applicationUptime;

    // The status of the application
    @JsonProperty("application-status")
    private ApplicationStatus applicationStatus;

    // The health information of dependencies of the application
    @JsonProperty("dependency-health")
    private List<HealthResponseDTO> dependencyHealths;

    /**
     * Constructs a new HealthResponseDTO object with the specified application
     * information and dependency health data.
     * 
     * @param applicationName    The name of the application.
     * @param applicationVersion The version of the application.
     * @param applicationUptime  The uptime of the application.
     * @param applicationStatus  The status of the application.
     * @param dependencyHealths  The health information of dependencies of the
     *                           application.
     */
    public HealthResponseDTO(String applicationName, String applicationVersion, String applicationUptime,
            ApplicationStatus applicationStatus, List<HealthResponseDTO> dependencyHealths) {
        this.applicationName = applicationName;
        this.applicationVersion = applicationVersion;
        this.applicationUptime = applicationUptime;
        this.applicationStatus = applicationStatus;
        this.dependencyHealths = dependencyHealths;
    }
}
