package com.demo.cca.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.cca.dto.response.SuccessResponseDTO;
import com.demo.cca.exceptions.InvalidRequestParameterException;
import com.demo.cca.helpers.CommonHelper;
import com.demo.cca.helpers.ValidationHelper;
import com.demo.cca.services.HealthService;

import lombok.extern.slf4j.Slf4j;

/**
 * Controller class for handling health check requests.
 */
@RestController
@Slf4j
public class HealthController {
    private HealthService healthService;

    /**
     * Constructor for the HealthController class.
     * 
     * @param healthService The service responsible for handling health-related
     *                      operations.
     */
    public HealthController(HealthService healthService) {
        log.debug("initializing health controller: " + this.getClass().getSimpleName());
        this.healthService = healthService;
    }

    /**
     * Endpoint to retrieve the health status of the application.
     * 
     * @param addExternalDependencyHealth A boolean flag indicating whether health
     *                                    information of external dependencies
     *                                    are required (optional).
     * @return A ResponseDTO containing the current timestamp and the health status
     *         of the application.
     */
    @GetMapping("/api/health")
    public SuccessResponseDTO getApplicationHealth(
            @RequestParam(name = "dependency-health", required = false) String addExternalDependencyHealth) {
        // log request
        log.info("received [GET - /api/health] request with query parameter value [dependency-health: "
                + addExternalDependencyHealth + "]");

        // validate request parameter
        log.info("validating query parameter value [dependency-health: " + addExternalDependencyHealth + "]");
        if (ValidationHelper.isAddExternalDependencyHealthQueryParameterValueInvalid(addExternalDependencyHealth)) {
            // throw exception
            throw new InvalidRequestParameterException("invalid value for request parameter [dependency-health: "
                    + addExternalDependencyHealth + "]");
        }

        // call service method to get the application health information and return
        log.info("generating health check response of the application");
        return CommonHelper.buildSuccessResponse(CommonHelper.getCurrentTimestampInFormatISO(false),
                this.healthService.getApplicationHealthData(Boolean.parseBoolean(addExternalDependencyHealth)));
    }
}
