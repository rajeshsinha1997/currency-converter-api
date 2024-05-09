package com.demo.cca.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.demo.cca.interfaces.IResponseData;

public class SuccessResponseDTOTest {
    // define mock test data
    private final String mockResponseTimestamp = "2024-05-07T12:00:00Z";
    private final IResponseData mockResponseData = Mockito.mock(IResponseData.class);

    @Test
    public void testConstructorAndGetters() {
        // create object of the class under test
        SuccessResponseDTO testObject = new SuccessResponseDTO(mockResponseTimestamp, mockResponseData);

        // test
        assertNotNull(testObject);
        assertEquals(mockResponseTimestamp, testObject.getResponseTimestamp());
        assertEquals(mockResponseData, testObject.getResponseData());
    }

    @Test
    public void testToString() {
        // get String representation of the object of the class under test
        String testObjectStringRepresentation = new SuccessResponseDTO(mockResponseTimestamp, mockResponseData)
                .toString();

        // test
        assertTrue(testObjectStringRepresentation.contains("responseTimestamp=" + mockResponseTimestamp));
        assertTrue(testObjectStringRepresentation.contains("responseData=" + mockResponseData));
    }
}
