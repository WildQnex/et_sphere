package org.martinyuk.sphere.util;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class LineSplitterTest {

    private String lineDefaultDelimiter;
    private String lineCustomDelimiter;

    @BeforeClass
    public void setUp() {
        lineDefaultDelimiter = "-11.4 4.1 1.2 -1.5 21.41";
        lineCustomDelimiter = "-26.4,4.21,1.21,-51.45";
    }

    @Test
    public void splitLineDefaultDelimiterTest() {
        String[] result = {"-11.4", "4.1", "1.2", "-1.5", "21.41"};
        assertEquals(LineSplitter.splitLine(lineDefaultDelimiter), result);
    }

    @Test
    public void splitLineCustomDelimiterTest() {
        String[] result = {"-26.4", "4.21", "1.21", "-51.45"};
        assertEquals(LineSplitter.splitLine(lineCustomDelimiter, ","), result);
    }

    @Test
    public void splitLineDefaultDelimiterNotEqualsTest() {
        String[] result = {};
        assertNotEquals(LineSplitter.splitLine(lineDefaultDelimiter), result);
    }

    @Test
    public void splitLineNCustomDelimiterNotEqualsTest() {
        String[] result = {};
        assertNotEquals(LineSplitter.splitLine(lineCustomDelimiter, ","), result);
    }
}
