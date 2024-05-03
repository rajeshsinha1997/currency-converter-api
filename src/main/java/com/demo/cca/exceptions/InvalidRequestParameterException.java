package com.demo.cca.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.ToString;

/**
 * Exception thrown when an invalid request parameter is encountered in the
 * application.
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
@ToString
public class InvalidRequestParameterException extends RuntimeException {

    /**
     * Constructs a new InvalidRequestParameterException with the specified detail
     * message.
     *
     * @param exceptionMessage the detail message.
     */
    public InvalidRequestParameterException(String exceptionMessage) {
        // call super class constructor
        super(exceptionMessage);
    }
}
