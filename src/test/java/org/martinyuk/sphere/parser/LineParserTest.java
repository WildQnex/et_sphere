package org.martinyuk.sphere.parser;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class LineParserTest {

    @Test
    public void lineParserTest() {
        String line = "5.41,-12.1,-14.2,15";
        String delimiter = ",";
        List<Double> result = new ArrayList<>();
        result.add(5.41);
        result.add(-12.1);
        result.add(-14.2);
        result.add(15D);
        assertEquals(LineParser.parseLine(line, delimiter), result);
    }

    @Test
    public void lineParserAnotherDelimiterTest() {
        String line = "5.41/-12.1/-14.2/15/-51.54";
        String delimiter = "/";
        List<Double> result = new ArrayList<>();
        result.add(5.41);
        result.add(-12.1);
        result.add(-14.2);
        result.add(15D);
        result.add(-51.54);
        assertEquals(LineParser.parseLine(line, delimiter), result);
    }

    @Test
    public void lineParserNotEqualsTest() {
        String line = "5.41,-12.1,-14.2,15";
        String delimiter = ",";
        List<Double> result = new ArrayList<>();
        assertNotEquals(LineParser.parseLine(line, delimiter), result);
    }
}