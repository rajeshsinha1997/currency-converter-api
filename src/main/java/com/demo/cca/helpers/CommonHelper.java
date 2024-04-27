package com.demo.cca.helpers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import com.demo.cca.dto.response.ResponseDTO;
import com.demo.cca.interfaces.IResponseData;

/**
 * Utility class providing common helper methods for various tasks.
 * This class contains static methods that can be used across the application
 * for common tasks.
 */
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
    public static String getCurrentTimestamp(boolean inUTC) {
        return LocalDateTime.now(inUTC ? ZoneOffset.UTC
                : ZoneId
                        .systemDefault())
                .format(DateTimeFormatter.ISO_DATE_TIME);
    }

    /**
     * Builds a response DTO with the provided timestamp and response data.
     * 
     * @param currentTimestamp The timestamp to include in the response DTO.
     * @param responseData     The response data to include in the response DTO.
     * @return A response DTO containing the provided timestamp and response data.
     */
    public static ResponseDTO buildResponse(String currentTimestamp, IResponseData responseData) {
        return new ResponseDTO(currentTimestamp, responseData);
    }
}
