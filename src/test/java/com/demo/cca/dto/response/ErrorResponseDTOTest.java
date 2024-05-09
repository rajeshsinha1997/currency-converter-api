package com.demo.cca.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ErrorResponseDTOTest {
    // define mock test data
    private final String mockTimestamp = "2024-05-07T12:00:00Z";
    private final String mockErrorMessage = "An error occurred";

    @Test
    public void testConstructorAndGetters() {
        // create object of class under test
        ErrorResponseDTO testObject = new ErrorResponseDTO(mockTimestamp, mockErrorMessage);

        // test
        assertNotNull(testObject);
        assertEquals(mockTimestamp, testObject.getErrorTimestamp());
        assertEquals(mockErrorMessage, testObject.getErrorMessage());
    }

    @Test
    public void testToString() {
        // get string representation of the object of the class under test
        String testObjectStringRepresentation = new ErrorResponseDTO(mockTimestamp, mockErrorMessage).toString();

        // test
        assertTrue(testObjectStringRepresentation.contains("errorTimestamp=" + mockTimestamp));
        assertTrue(testObjectStringRepresentation.contains("errorMessage=" + mockErrorMessage));
    }
}
