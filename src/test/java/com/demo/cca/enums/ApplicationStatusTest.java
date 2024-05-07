package com.demo.cca.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ApplicationStatusTest {
    @Test
    public void testEnumValues() {
        // test
        assertEquals("up", ApplicationStatus.UP.getEnumValue());
        assertEquals("down", ApplicationStatus.DOWN.getEnumValue());
    }
}
