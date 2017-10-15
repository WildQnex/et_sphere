package org.martinyuk.sphere.reader;

import org.martinyuk.sphere.cache.SphereCache;
import org.martinyuk.sphere.exception.FactoryException;
import org.martinyuk.sphere.exception.FileReaderException;
import org.martinyuk.sphere.factory.EntityFactory;
import org.martinyuk.sphere.util.PointIdGenerator;
import org.martinyuk.sphere.util.SphereIdGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class FileReaderTest {

    private final String FILE2 = "data.txt";

    private File file;

    private String errorMessage;


    @BeforeClass
    public void setUp() throws IOException {
        file = File.createTempFile("tmp", "txt");
        file.deleteOnExit();

        try (FileWriter fileWriter = new FileWriter(file.getAbsolutePath());
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write("2.5,6.3,6.1,3.6\n" +
                                     "4.2,5.2,4.3,6.2\n" +
                                     "3.4,5.7,8.2,9.0\n");
        }
        errorMessage = "File wasn't found, file path = " + FILE2;
    }

    @Test
    public void getDataTest() throws FileReaderException {
        List<String> result = new ArrayList<>();
        result.add("2.5,6.3,6.1,3.6");
        result.add("4.2,5.2,4.3,6.2");
        result.add("3.4,5.7,8.2,9.0");
        assertEquals(FileReader.readLines(file.getAbsolutePath()), result);
    }

    @Test
    public void getDataNotEqualsTest() throws FileReaderException {
        List<String> result = new ArrayList<>();
        result.add("2.1,6.3,6.1,3.6");
        result.add("4.2,5.2,1.3,6.2");
        result.add("3.4,5.1,8.2,9.0");
        assertNotEquals(FileReader.readLines(file.getAbsolutePath()), result);
    }

    @Test(expectedExceptions = FileReaderException.class)
    public void getDataFileNotFoundTest() throws FileReaderException {
        FileReader.readLines(FILE2);
    }

    @Test
    public void getDataErrorMessageTest() {
        try {
            FileReader.readLines(FILE2);
            fail();
        } catch (FileReaderException e) {
            assertEquals(e.getMessage(), errorMessage);
        }
    }
}
