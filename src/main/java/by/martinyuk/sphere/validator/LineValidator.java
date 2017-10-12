package by.martinyuk.sphere.validator;

import java.util.regex.Pattern;

public class LineValidator {

    private static final String COORDINATE = "(-?\\d{1,4}.?\\d{0,4},)";
    private static final String LAST_COORDINATE = "(-?\\d{1,4}.?\\d{0,4})";
    private static final String RADIUS = "(\\d{1,4}.?\\d{0,4})";
    private static final Pattern SPHERE_LINE_REGEXP = Pattern.compile(COORDINATE + "{3}" + RADIUS);
    private static final Pattern POINT_LINE_REGEXP = Pattern.compile(COORDINATE + "{2}" + LAST_COORDINATE);


    private LineValidator() {

    }

    public static boolean validateSphereLine(String line) {
        return SPHERE_LINE_REGEXP.matcher(line).matches();
    }

    public static boolean validatePointLine(String line) {
        return POINT_LINE_REGEXP.matcher(line).matches();
    }
}
