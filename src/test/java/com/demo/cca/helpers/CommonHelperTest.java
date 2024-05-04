package com.demo.cca.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import com.demo.cca.dto.response.ErrorResponseDTO;
import com.demo.cca.dto.response.SuccessResponseDTO;
import com.demo.cca.interfaces.IResponseData;

class CommonHelperTest {

    // define mock datetime in system timezone
    private static final LocalDateTime mockDateTime = LocalDateTime.now();

    @Test
    void testGetCurrentTimestampInFormatISOInUTC() {
        // mock call to LocalDateTime.now
        try (MockedStatic<LocalDateTime> mockedLocalDateTime = Mockito.mockStatic(LocalDateTime.class)) {
            // apply mock
            mockedLocalDateTime.when(LocalDateTime::now).thenReturn(mockDateTime);

            // define expected datetime in UTC timezone
            String expectedData = mockDateTime.atZone(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME);

            // get actual data from function under test
            String actualData = CommonHelper.getCurrentTimestampInFormatISO(true);

            // test
            assertNotNull(actualData);
            assertEquals(expectedData, actualData);
        }
    }

    @Test
    void testGetCurrentTimestampInFormatISOInSystemTimeZone() {

        // mock call to LocalDateTime.now
        try (MockedStatic<LocalDateTime> mockedLocalDateTime = Mockito.mockStatic(LocalDateTime.class)) {
            // apply mock
            mockedLocalDateTime.when(LocalDateTime::now).thenReturn(mockDateTime);

            // define expected datetime in system timezone
            String expectedData = mockDateTime
                    .atZone(ZoneOffset.systemDefault())
                    .format(DateTimeFormatter.ISO_DATE_TIME);

            // get actual data from function under test
            String actualData = CommonHelper.getCurrentTimestampInFormatISO(false);

            // test
            assertNotNull(actualData);
            assertEquals(expectedData, actualData);
        }
    }

    @Test
    void testBuildSuccessResponse() {
        // define mock response data object
        IResponseData mockResponseData = mock(IResponseData.class);

        // get actual data from function under test
        SuccessResponseDTO actualData = CommonHelper.buildSuccessResponse(mockDateTime.toString(),
                mockResponseData);

        // test
        assertNotNull(actualData);
        assertEquals(mockDateTime.toString(), actualData.getResponseTimestamp());
        assertEquals(mockResponseData, actualData.getResponseData());
    }

    @Test
    void testBuildErrorResponse() {
        // define mock error message
        String mockErrorMessage = "mock error message";

        // get actual data from function under test
        ErrorResponseDTO actualData = CommonHelper.buildErrorResponse(mockDateTime.toString(), mockErrorMessage);

        // test
        assertNotNull(actualData);
        assertEquals(mockDateTime.toString(), actualData.getErrorTimestamp());
        assertEquals(mockErrorMessage, actualData.getErrorMessage());
    }

    @Test
    void testConvertEnvironmentVariableNameToPropertyKey() {
        // define expected property key
        String expectedPropertyKey = "mock.property.key";

        // get actual data from function under test
        String actualData = CommonHelper.convertEnvironmentVariableNameToPropertyKey("MOCK_PROPERTY_KEY");

        // test
        assertNotNull(actualData);
        assertEquals(expectedPropertyKey, actualData);
    }

}
