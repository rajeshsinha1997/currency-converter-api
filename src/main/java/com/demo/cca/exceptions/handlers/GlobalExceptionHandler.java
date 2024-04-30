package com.demo.cca.exceptions.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.cca.dto.response.ErrorResponseDTO;
import com.demo.cca.exceptions.InvalidRequestParameterException;
import com.demo.cca.helpers.CommonHelper;

/**
 * Global exception handler for handling exceptions thrown from REST
 * controllers.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Global exception handler for handling unhandled exceptions.
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseDTO defaultExceptionHandler() {
        // return error response
        return CommonHelper.buildErrorResponse(CommonHelper.getCurrentTimestamp(false), "some internal error occurred");
    }

    /**
     * Exception handler for InvalidRequestParameterException.
     * 
     * @param exception The InvalidRequestParameterException instance.
     * @return An ErrorResponseDTO containing the error timestamp and message.
     */
    @ExceptionHandler(InvalidRequestParameterException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handleInvalidRequestParameterException(InvalidRequestParameterException exception) {
        // return error response
        return CommonHelper.buildErrorResponse(CommonHelper.getCurrentTimestamp(false), exception.getMessage());
    }
}
