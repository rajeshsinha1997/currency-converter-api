package com.demo.cca.services;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.demo.cca.dto.response.HealthResponseDTO;
import com.demo.cca.enums.ApplicationStatus;
import lombok.extern.slf4j.Slf4j;

/**
 * Service class responsible for retrieving application health data.
 * This class provides methods to fetch information about the health status of
 * the application.
 */
@Service
@Slf4j
public class HealthService {
    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${spring.application.version}")
    private String applicationVersion;

    private final Clock clock;

    private Instant startTime;

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
        log.info("setting application start time");
        this.startTime = Instant.now(this.clock);
        log.debug("successfully set application start time: " + this.startTime);
    }

    /**
     * Calculates the uptime of the application in the format HH:MM:SS.
     * 
     * @return A string representing the uptime of the application.
     */
    public String getApplicationUptime() {
        log.info("calculating application uptime duration");

        // calculate uptime duration in seconds
        long uptimeDurationInSeconds = (this.startTime == null ? Duration.ZERO
                : Duration.between(startTime,
                        Instant.now(this.clock)))
                .getSeconds();
        log.debug("application uptime total duration in seconds: " + uptimeDurationInSeconds);

        // calculate uptime hours
        long hours = uptimeDurationInSeconds / 3600;
        log.debug("application uptime hours value: " + hours);

        // calculate uptime minutes
        long minutes = (uptimeDurationInSeconds % 3600) / 60;
        log.debug("application uptime minutes value: " + minutes);

        // calculate uptime seconds
        long seconds = uptimeDurationInSeconds % 60;
        log.debug("application uptime seconds value: " + seconds);

        // format uptime value and return
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    /**
     * Retrieves the health data of the application.
     * 
     * @param addExternalDependencyHealth A boolean flag indicating whether health
     *                                    information of external services are
     *                                    required (optional).
     * @return A HealthResponseDTO containing the health status of the application.
     */
    public HealthResponseDTO getApplicationHealthData(boolean addExternalDependencyHealth) {
        // create instance of HealthResponseDTO containing the application health status
        log.debug("generating application health check data");
        HealthResponseDTO applicationHealth = new HealthResponseDTO(
                this.applicationName,
                this.applicationVersion,
                this.getApplicationUptime(),
                ApplicationStatus.UP,
                new ArrayList<>());
        log.info("generated application health check data: " + applicationHealth);

        // check if we need to add health information of external services
        if (addExternalDependencyHealth) {
            log.info("adding health check data of external dependencies");
            // add health information of external services
        }

        // return application health information
        log.info("finished generating application health check data: " + applicationHealth);
        return applicationHealth;
    }
}
