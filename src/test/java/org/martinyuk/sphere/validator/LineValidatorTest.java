package org.martinyuk.sphere.validator;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class LineValidatorTest {

    @Test
    public void validateLineTest() {
        String validLine = "12.4,542.1,34.1,12.24";
        assertTrue(LineValidator.validateSphereLine(validLine));
    }

    @Test
    public void validateLineNegativeNumbersTest() {
        String validLine = "-12.4,542.1,-34.1,12.24";
        assertTrue(LineValidator.validateSphereLine(validLine));
    }

    @Test
    public void validateLineInvalidSymbolsTest() {
        String invalidLine = "12.z4,542.1,34.1,12.24";
        assertFalse(LineValidator.validateSphereLine(invalidLine));
    }

    @Test
    public void validateLineInvalidParametersAmountTest() {

        String invalidLine = "12.4,542.1,-34.1,12.24,41.1";
        assertFalse(LineValidator.validateSphereLine(invalidLine));
    }

    @Test
    public void validateLineInvalidNegativeRadiusTest() {
        String invalidLine = "12.4,542.1,34.1,-12.24";
        assertFalse(LineValidator.validateSphereLine(invalidLine));
    }
}