package com.demo.cca.helpers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ValidationHelperTest {
    @Test
    void testIsAddExternalDependencyHealthQueryParameterValueInvalid() {
        // test
        assertFalse(ValidationHelper.isAddExternalDependencyHealthQueryParameterValueInvalid("true"));
        assertFalse(ValidationHelper.isAddExternalDependencyHealthQueryParameterValueInvalid("false"));

        assertTrue(ValidationHelper.isAddExternalDependencyHealthQueryParameterValueInvalid(null));
        assertTrue(ValidationHelper.isAddExternalDependencyHealthQueryParameterValueInvalid(""));
        assertTrue(ValidationHelper.isAddExternalDependencyHealthQueryParameterValueInvalid("TRUE"));
        assertTrue(ValidationHelper.isAddExternalDependencyHealthQueryParameterValueInvalid("True"));
        assertTrue(ValidationHelper.isAddExternalDependencyHealthQueryParameterValueInvalid("T"));
        assertTrue(ValidationHelper.isAddExternalDependencyHealthQueryParameterValueInvalid("t"));
        assertTrue(ValidationHelper.isAddExternalDependencyHealthQueryParameterValueInvalid("FALSE"));
        assertTrue(ValidationHelper.isAddExternalDependencyHealthQueryParameterValueInvalid("False"));
        assertTrue(ValidationHelper.isAddExternalDependencyHealthQueryParameterValueInvalid("F"));
        assertTrue(ValidationHelper.isAddExternalDependencyHealthQueryParameterValueInvalid("f"));
    }
}
