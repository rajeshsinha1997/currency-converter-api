package com.demo.cca.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.cca.dto.response.ResponseDTO;
import com.demo.cca.helpers.CommonHelper;

/**
 * Controller class for handling health check requests.
 */
@RestController
public class HealthController {
    /**
     * Endpoint to retrieve the health status of the application.
     *
     * @return A ResponseDTO containing the current timestamp and the health status
     *         of the application.
     */
    @GetMapping("/api/health")
    public ResponseDTO getApplicationHealth() {
        return CommonHelper.buildResponse(CommonHelper.getCurrentTimestamp(false), null);
    }
}
