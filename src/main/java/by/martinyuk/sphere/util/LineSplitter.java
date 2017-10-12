package by.martinyuk.sphere.util;

public class LineSplitter {

    private final static String DEFAULT_DELIMITER = "\\s";

    private LineSplitter() {
    }

    public static String[] splitLine(String line) {
        line = line.trim();
        return line.split(DEFAULT_DELIMITER);
    }

    public static String[] splitLine(String line, String delimiter) {
        line = line.trim();
        return line.split(delimiter);
    }
}
