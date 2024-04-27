package com.demo.cca.dto.response;

import com.demo.cca.interfaces.IResponseData;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a generic response DTO (Data Transfer Object) containing response
 * data and timestamp.
 */
public class ResponseDTO {

    @JsonProperty("response-timestamp")
    private String responseTimestamp;

    @JsonProperty("response-data")
    private IResponseData responseData;

    /**
     * Constructs a ResponseDTO object with the specified response timestamp and
     * response data.
     *
     * @param responseTimestamp The timestamp of the response.
     * @param responseData      The response data.
     */
    public ResponseDTO(String responseTimestamp, IResponseData responseData) {
        this.responseTimestamp = responseTimestamp;
        this.responseData = responseData;
    }

}
