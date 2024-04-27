package com.demo.cca.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.cca.dto.response.ResponseDTO;
import com.demo.cca.helpers.CommonHelper;

/**
 * Controller class for handling currency conversion requests.
 */
@RestController
public class CurrencyConverterController {
    /**
     * Endpoint for converting currencies.
     * This method handles GET requests to "/api/currency/convert" and returns a
     * ResponseDTO containing the current timestamp and the result of currency
     * conversion.
     * 
     * @return A ResponseDTO containing the current timestamp and the result of
     *         currency conversion.
     */
    @GetMapping("/api/currency/convert")
    public ResponseDTO getMethodName() {
        return CommonHelper.buildResponse(CommonHelper.getCurrentTimestamp(false), null);
    }
}
