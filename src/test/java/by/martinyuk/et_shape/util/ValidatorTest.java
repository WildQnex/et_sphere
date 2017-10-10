package by.martinyuk.et_shape.util;

import by.martinyuk.et_sphere.util.Validator;
import org.testng.annotations.*;

import static org.testng.Assert.*;


public class ValidatorTest {

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
        assertTrue(Validator.validateSphereLine(validLine1));
    }

    @Test
    public void validateLineNegativeNumbersTest(){
        assertTrue(Validator.validateSphereLine(validLine2));
    }

    @Test
    public void validateLineInvalidSymbolsTest(){
        assertFalse(Validator.validateSphereLine(invalidLine1));
    }

    @Test
    public void validateLineInvalidParametersAmountTest(){
        assertFalse(Validator.validateSphereLine(invalidLine2));
    }

    @Test
    public void validateLineInvalidNegativeRadiusTest(){
        assertFalse(Validator.validateSphereLine(invalidLine3));
    }
}