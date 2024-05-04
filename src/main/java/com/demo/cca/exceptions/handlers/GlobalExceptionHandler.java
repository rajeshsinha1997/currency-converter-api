package com.demo.cca.exceptions.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.cca.dto.response.ErrorResponseDTO;
import com.demo.cca.exceptions.InvalidRequestParameterException;
import com.demo.cca.helpers.CommonHelper;

import lombok.extern.slf4j.Slf4j;

/**
 * Global exception handler for handling exceptions thrown from REST
 * controllers.
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * Global exception handler for handling unhandled exceptions.
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseDTO defaultExceptionHandler(Exception exception) {
        // return error response
        log.error("handling " + exception.getClass().getSimpleName() + " in default handler: "
                + exception.getLocalizedMessage());
        return CommonHelper.buildErrorResponse(CommonHelper.getCurrentTimestampInFormatISO(false),
                "some internal error occurred");
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
        log.error("handling " + exception.getClass().getSimpleName() + " : " + exception.getLocalizedMessage());
        return CommonHelper.buildErrorResponse(CommonHelper.getCurrentTimestampInFormatISO(false),
                exception.getMessage());
    }
}
