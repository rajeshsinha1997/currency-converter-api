package com.demo.cca.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ErrorResponseDTOTest {
    @Test
    public void testConstructorAndGetters() {
        // define mock test data
        String mockTimestamp = "2024-05-07T12:00:00Z";
        String mockErrorMessage = "An error occurred";

        // create object of class under test
        ErrorResponseDTO testObject = new ErrorResponseDTO(mockTimestamp, mockErrorMessage);

        // test
        assertEquals(mockTimestamp, testObject.getErrorTimestamp());
        assertEquals(mockErrorMessage, testObject.getErrorMessage());
    }

    @Test
    public void testToString() {
        // define mock test data
        String mockTimestamp = "2024-05-07T12:00:00Z";
        String mockErrorMessage = "An error occurred";

        // create string representation of the object of the class under test
        String testObjectStringRepresentation = new ErrorResponseDTO(mockTimestamp, mockErrorMessage).toString();

        // test
        assertTrue(testObjectStringRepresentation.contains("errorTimestamp=" + mockTimestamp));
        assertTrue(testObjectStringRepresentation.contains("errorMessage=" + mockErrorMessage));
    }
}
