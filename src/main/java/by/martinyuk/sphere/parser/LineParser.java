package by.martinyuk.sphere.parser;

import by.martinyuk.sphere.util.LineSplitter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LineParser {

    private LineParser() {
    }

    public static List<Double> parseLine(String line, String delimiter) {
        return Arrays.stream(LineSplitter.splitLine(line, delimiter))
                .mapToDouble(Double::parseDouble)
                .boxed()
                .collect(Collectors.toList());
    }
}
