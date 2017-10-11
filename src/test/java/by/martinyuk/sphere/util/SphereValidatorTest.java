package by.martinyuk.sphere.util;

import by.martinyuk.sphere.validator.SphereValidator;
import org.testng.annotations.*;

import static org.testng.Assert.*;


public class SphereValidatorTest {

    private String validLine1;
    private String validLine2;
    private String invalidLine1;
    private String invalidLine2;
    private String invalidLine3;


    @BeforeClass
    public void setup(){

        validLine1 = "12.4,542.1,34.1,12.24";
        validLine2 = "-12.4,542.1,-34.1,12.24";

        invalidLine1 = "12.z4,542.1,34.1,12.24";
        invalidLine2 = "12.4,542.1,-34.1,12.24,41.1";
        invalidLine3 = "12.4,542.1,34.1,-12.24";

    }

    @Test
    public void validateLineTest(){
        assertTrue(SphereValidator.validateSphereLine(validLine1));
    }

    @Test
    public void validateLineNegativeNumbersTest(){
        assertTrue(SphereValidator.validateSphereLine(validLine2));
    }

    @Test
    public void validateLineInvalidSymbolsTest(){
        assertFalse(SphereValidator.validateSphereLine(invalidLine1));
    }

    @Test
    public void validateLineInvalidParametersAmountTest(){
        assertFalse(SphereValidator.validateSphereLine(invalidLine2));
    }

    @Test
    public void validateLineInvalidNegativeRadiusTest(){
        assertFalse(SphereValidator.validateSphereLine(invalidLine3));
    }
}