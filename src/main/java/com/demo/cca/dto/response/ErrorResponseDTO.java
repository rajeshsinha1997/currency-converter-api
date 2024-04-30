package com.demo.cca.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data Transfer Object (DTO) representing an error response.
 */
public class ErrorResponseDTO {

    @JsonProperty("error-timestamp")
    private String errorTimestamp;

    @JsonProperty("error-message")
    private String errorMessage;

    /**
     * Constructs an ErrorResponseDTO object with the specified error timestamp and
     * error message.
     *
     * @param errorTimestamp The timestamp of the error.
     * @param errorMessage   The error message.
     */
    public ErrorResponseDTO(String errorTimestamp, String errorMessage) {
        this.errorTimestamp = errorTimestamp;
        this.errorMessage = errorMessage;
    }
}
