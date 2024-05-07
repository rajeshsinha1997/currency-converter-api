package com.demo.cca.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.demo.cca.interfaces.IResponseData;

public class SuccessResponseDTOTest {
    @Test
    public void testConstructorAndGetters() {
        // define mock test data
        String mockResponseTimestamp = "2024-05-07T12:00:00Z";
        IResponseData mockResponseData = Mockito.mock(IResponseData.class);

        // create object of the class under test
        SuccessResponseDTO testObject = new SuccessResponseDTO(mockResponseTimestamp, mockResponseData);

        // test
        assertEquals(mockResponseTimestamp, testObject.getResponseTimestamp());
        assertEquals(mockResponseData, testObject.getResponseData());
    }

    @Test
    public void testToString() {
        // define mock test data
        String mockResponseTimestamp = "2024-05-07T12:00:00Z";
        IResponseData mockResponseData = Mockito.mock(IResponseData.class);

        // create String representation of the object of the class under test
        String testObjectStringRepresentation = new SuccessResponseDTO(mockResponseTimestamp, mockResponseData)
                .toString();

        // test
        assertTrue(testObjectStringRepresentation.contains("responseTimestamp=" + mockResponseTimestamp));
        assertTrue(testObjectStringRepresentation.contains("responseData=" + mockResponseData));
    }
}
