package com.demo.cca.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.cca.dto.response.SuccessResponseDTO;
import com.demo.cca.helpers.CommonHelper;

/**
 * Controller class for handling currency conversion requests.
 */
@RestController
public class CurrencyConverterController {
    /**
     * Endpoint for converting currencies.
     * This method handles GET requests to "/api/currency/convert" and returns a
     * SuccessResponseDTO containing the current timestamp and the result of
     * currency conversion.
     * 
     * @return A SuccessResponseDTO containing the current timestamp and the result
     *         of currency conversion.
     */
    @GetMapping("/api/currency/convert")
    public SuccessResponseDTO getMethodName() {
        return CommonHelper.buildSuccessResponse(CommonHelper.getCurrentTimestampInFormatISO(false), null);
    }
}
