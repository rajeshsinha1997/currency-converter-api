package com.demo.cca.services;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.demo.cca.dto.response.HealthResponseDTO;
import com.demo.cca.enums.ApplicationStatus;
import com.demo.cca.helpers.EnvironmentHelper;

/**
 * Service class responsible for retrieving application health data.
 * This class provides methods to fetch information about the health status of
 * the application.
 */
@Service
public class HealthService {
    private Instant startTime;

    private final Clock clock;

    /**
     * Constructor for the HealthService class.
     */
    public HealthService() {
        this.clock = Clock.systemDefaultZone();
    }

    /**
     * Sets the start time of the application when it is ready.
     * This method is annotated with @EventListener to be triggered when the
     * ApplicationReadyEvent is published.
     */
    @EventListener(ApplicationReadyEvent.class)
    public void setStartTime() {
        // set the application start time
        this.startTime = Instant.now(this.clock);
    }

    /**
     * Calculates the uptime of the application in the format HH:MM:SS.
     * 
     * @return A string representing the uptime of the application.
     */
    private String getApplicationUptime() {
        // calculate uptime duration in seconds
        long uptimeDurationInSeconds = (this.startTime == null ? Duration.ZERO
                : Duration.between(startTime,
                        Instant.now(this.clock)))
                .getSeconds();

        // calculate uptime hours
        long hours = uptimeDurationInSeconds / 3600;

        // calculate uptime minutes
        long minutes = (uptimeDurationInSeconds % 3600) / 60;

        // calculate uptime seconds
        long seconds = uptimeDurationInSeconds % 60;

        // format uptime value and return
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    /**
     * Retrieves the health data of the application.
     * 
     * @return A HealthResponseDTO containing the health status of the application.
     */
    public HealthResponseDTO getApplicationHealthData() {
        // retrieve application name
        String applicationName = EnvironmentHelper
                .resolveEnvironmentVariableOrPropertyValue("SPRING_APPLICATION_NAME");

        // retrieve application version
        String applicationVersion = EnvironmentHelper
                .resolveEnvironmentVariableOrPropertyValue("SPRING_APPLICATION_VERSION");

        // return HealthResponseDTO containing the application health status
        return new HealthResponseDTO(
                applicationName,
                applicationVersion,
                this.getApplicationUptime(),
                ApplicationStatus.UP,
                new ArrayList<>());
    }
}
