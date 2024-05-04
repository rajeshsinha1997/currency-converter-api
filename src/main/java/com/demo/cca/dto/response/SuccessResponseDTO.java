package com.demo.cca.dto.response;

import com.demo.cca.interfaces.IResponseData;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

/**
 * Represents a generic response DTO (Data Transfer Object) containing response
 * data and timestamp.
 */
@ToString
public class SuccessResponseDTO {

    @JsonProperty("response-timestamp")
    @Getter
    private String responseTimestamp;

    @JsonProperty("response-data")
    @Getter
    private IResponseData responseData;

    /**
     * Constructs a SuccessResponseDTO object with the specified response timestamp
     * and response data.
     *
     * @param responseTimestamp The timestamp of the response.
     * @param responseData      The response data.
     */
    public SuccessResponseDTO(String responseTimestamp, IResponseData responseData) {
        this.responseTimestamp = responseTimestamp;
        this.responseData = responseData;
    }

}
