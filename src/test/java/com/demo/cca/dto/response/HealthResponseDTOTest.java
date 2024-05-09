package com.demo.cca.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.demo.cca.enums.ApplicationStatus;
import com.demo.cca.interfaces.IResponseData;

public class HealthResponseDTOTest {
    // define mock test data
    private final String mockApplicationName = "TestApp";
    private final String mockApplicationVersion = "1.0";
    private final String mockApplicationUptime = "12 hours";
    ApplicationStatus mockApplicationStatus = ApplicationStatus.UP;
    List<HealthResponseDTO> mockDependencyHealths = new ArrayList<>();

    @Test
    public void testConstructorAndGetters() {
        // create object of the class under test
        HealthResponseDTO testObject = new HealthResponseDTO(mockApplicationName, mockApplicationVersion,
                mockApplicationUptime, mockApplicationStatus, mockDependencyHealths);

        // test
        assertNotNull(testObject);
        assertTrue(testObject instanceof IResponseData);
        assertEquals(mockApplicationName, testObject.getApplicationName());
        assertEquals(mockApplicationVersion, testObject.getApplicationVersion());
        assertEquals(mockApplicationUptime, testObject.getApplicationUptime());
        assertEquals(mockApplicationStatus, testObject.getApplicationStatus());
        assertEquals(mockDependencyHealths, testObject.getDependencyHealths());
    }

    @Test
    public void testToString() {
        // get string representation of the object of the class under test
        String testObjectStringRepresentation = new HealthResponseDTO(mockApplicationName, mockApplicationVersion,
                mockApplicationUptime, mockApplicationStatus, mockDependencyHealths).toString();

        // test
        assertTrue(testObjectStringRepresentation.contains("applicationName=" + mockApplicationName));
        assertTrue(testObjectStringRepresentation.contains("applicationVersion=" + mockApplicationVersion));
        assertTrue(testObjectStringRepresentation.contains("applicationUptime=" + mockApplicationUptime));
        assertTrue(testObjectStringRepresentation.contains("applicationStatus=" + mockApplicationStatus));
        assertTrue(testObjectStringRepresentation.contains("dependencyHealths=" + mockDependencyHealths));
    }
}
