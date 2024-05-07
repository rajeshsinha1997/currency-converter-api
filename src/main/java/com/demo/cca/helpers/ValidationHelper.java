package com.demo.cca.helpers;

/**
 * Helper class responsible for performing all validation work.
 */
public class ValidationHelper {

    /**
     * Validates the query parameter for adding external dependency health.
     * 
     * @param queryParameterValue The value of the query parameter to validate.
     * @return {@code true} if the query parameter is invalid, {@code false}
     *         otherwise.
     */
    public static boolean isAddExternalDependencyHealthQueryParameterValueInvalid(String queryParameterValue) {
        return queryParameterValue == null
                || (!queryParameterValue.equals("true") && !queryParameterValue.equals("false"));
    }
}
