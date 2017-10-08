package by.martinyuk.et_sphere.util;

import java.util.regex.Pattern;

public class Validator {

    private final static Pattern COORDINATE_REGEX = Pattern.compile("-?[0-9]{1,4}.[0-9]{1,4}");
    private final static Pattern RADIUS_REGEX = Pattern.compile("[0-9]{1,4}.[0-9]{1,4}");

    public static boolean validateLine(String line){
        String[] numbers = line.split(" ");

        if(numbers.length != 4){
            return false;
        }

        for(int i = 0; i < 3; i++){
            if(!validateCoordinate(numbers[i])){
                return false;
            }
        }

        return validateRadius(numbers[3]);
    }

    private static boolean validateCoordinate(String num){
        return COORDINATE_REGEX.matcher(num).matches();
    }

    private static boolean validateRadius(String num){
        return RADIUS_REGEX.matcher(num).matches();
    }
}
