package org.martinyuk.sphere.validator;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class LineValidatorTest {

    @Test
    public void validateSphereLineTest() {
        String validLine = "12.4,542.1,34.1,12.24";
        assertTrue(LineValidator.validateSphereLine(validLine));
    }

    @Test
    public void validateSphereLineNegativeNumbersTest() {
        String validLine = "-12.4,542.1,-34.1,12.24";
        assertTrue(LineValidator.validateSphereLine(validLine));
    }

    @Test
    public void validateSphereLineInvalidSymbolsTest() {
        String invalidLine = "12.z4,542.1,34.1,12.24";
        assertFalse(LineValidator.validateSphereLine(invalidLine));
    }

    @Test
    public void validateSphereLineInvalidParametersAmountTest() {

        String invalidLine = "12.4,542.1,-34.1,12.24,41.1";
        assertFalse(LineValidator.validateSphereLine(invalidLine));
    }

    @Test
    public void validateSphereLineInvalidNegativeRadiusTest() {
        String invalidLine = "12.4,542.1,34.1,-12.24";
        assertFalse(LineValidator.validateSphereLine(invalidLine));
    }

    @Test
    public void validatePointLineTest() {
        String validLine = "12.4,542.1,34.1";
        assertTrue(LineValidator.validatePointLine(validLine));
    }

    @Test
    public void validatePointLineNegativeNumbersTest() {
        String validLine = "-12.4,-34.1,12.24";
        assertTrue(LineValidator.validatePointLine(validLine));
    }

    @Test
    public void validatePointLineInvalidSymbolsTest() {
        String invalidLine = "12.z4,542.1,34.1";
        assertFalse(LineValidator.validatePointLine(invalidLine));
    }

    @Test
    public void validatePointLineInvalidParametersAmountTest() {

        String invalidLine = "12.4,-34.1,12.24,41.1";
        assertFalse(LineValidator.validatePointLine(invalidLine));
    }

}