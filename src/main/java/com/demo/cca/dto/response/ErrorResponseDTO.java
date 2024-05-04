package com.demo.cca.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

/**
 * Data Transfer Object (DTO) representing an error response.
 */
@ToString
public class ErrorResponseDTO {

    @JsonProperty("error-timestamp")
    @Getter
    private String errorTimestamp;

    @JsonProperty("error-message")
    @Getter
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
