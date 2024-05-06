package com.demo.cca.helpers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import com.demo.cca.dto.response.ErrorResponseDTO;
import com.demo.cca.dto.response.SuccessResponseDTO;
import com.demo.cca.interfaces.IResponseData;

import lombok.extern.slf4j.Slf4j;

/**
 * Utility class providing common helper methods for various tasks.
 * This class contains static methods that can be used across the application
 * for common tasks.
 */
@Slf4j
public class CommonHelper {
    // private constructor to prevent instantiation
    private CommonHelper() {
    }

    /**
     * Gets the current timestamp formatted in ISO 8601 format.
     * 
     * @param inUTC Flag indicating whether the timestamp should be retrieved in UTC
     *              timezone.
     * @return The current timestamp formatted in ISO 8601 format.
     */
    public static String getCurrentTimestampInFormatISO(boolean inUTC) {
        log.info("retrieving current timestamp in " + (inUTC ? "UTC" : "LOCAL") + " timezone");
        return LocalDateTime.now().atZone(inUTC ? ZoneOffset.UTC : ZoneId.systemDefault())
                .format(DateTimeFormatter.ISO_DATE_TIME);
    }

    /**
     * Builds a response DTO with the provided timestamp and response data.
     * 
     * @param currentTimestamp The timestamp to include in the response DTO.
     * @param responseData     The response data to include in the response DTO.
     * @return A response DTO containing the provided timestamp and response data.
     */
    public static SuccessResponseDTO buildSuccessResponse(String currentTimestamp, IResponseData responseData) {
        log.info("building success response with timestamp: " + currentTimestamp + ", data: " + responseData);
        return new SuccessResponseDTO(currentTimestamp, responseData);
    }

    /**
     * Builds an ErrorResponseDTO object with the specified error timestamp and
     * error message.
     *
     * @param errorTimestamp The timestamp of the error.
     * @param errorMessage   The error message.
     * @return An ErrorResponseDTO object representing the error response.
     */
    public static ErrorResponseDTO buildErrorResponse(String errorTimestamp, String errorMessage) {
        log.info("building error response with timestamp: " + errorTimestamp + ", message: " + errorMessage);
        return new ErrorResponseDTO(errorTimestamp, errorMessage);
    }
}
