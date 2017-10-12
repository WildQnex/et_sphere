package by.martinyuk.sphere.validator;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class LineValidatorTest {

    private String validLine1;
    private String validLine2;
    private String invalidLine1;
    private String invalidLine2;
    private String invalidLine3;


    @BeforeClass
    public void setup() {

        validLine1 = "12.4,542.1,34.1,12.24";
        validLine2 = "-12.4,542.1,-34.1,12.24";

        invalidLine1 = "12.z4,542.1,34.1,12.24";
        invalidLine2 = "12.4,542.1,-34.1,12.24,41.1";
        invalidLine3 = "12.4,542.1,34.1,-12.24";

    }

    @Test
    public void validateLineTest() {
        assertTrue(LineValidator.validateSphereLine(validLine1));
    }

    @Test
    public void validateLineNegativeNumbersTest() {
        assertTrue(LineValidator.validateSphereLine(validLine2));
    }

    @Test
    public void validateLineInvalidSymbolsTest() {
        assertFalse(LineValidator.validateSphereLine(invalidLine1));
    }

    @Test
    public void validateLineInvalidParametersAmountTest() {
        assertFalse(LineValidator.validateSphereLine(invalidLine2));
    }

    @Test
    public void validateLineInvalidNegativeRadiusTest() {
        assertFalse(LineValidator.validateSphereLine(invalidLine3));
    }
}