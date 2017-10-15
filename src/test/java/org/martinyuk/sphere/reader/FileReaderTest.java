package org.martinyuk.sphere.reader;

import org.martinyuk.sphere.exception.FactoryException;
import org.martinyuk.sphere.exception.FileReaderException;
import org.martinyuk.sphere.factory.EntityFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class FileReaderTest {

    private final String FILE1 = "data/data.txt";
    private final String FILE2 = "data.txt";

    private String errorMessage;

    private List<String> list1 = new ArrayList<>();
    private List<String> list2 = new ArrayList<>();

    @BeforeClass
    public void setup() {
        errorMessage = "File wasn't found, file path = " + FILE2;

        list1.add("2.5,6.3,6.1,3.6");
        list1.add("4.2,5.2,4.3,6.2");
        list1.add("3.4,5.7,8.2,9.0");

        list2.add("2.1,6.3,6.1,3.6");
        list2.add("4.2,5.2,1.3,6.2");
        list2.add("3.4,5.1,8.2,9.0");

        try {
            EntityFactory.factoryMethod("Sphere");
        } catch (FactoryException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getDataTest() throws FileReaderException {
        assertEquals(FileReader.readLines(FILE1), list1);
    }

    @Test
    public void getDataNotEqualsTest() throws FileReaderException {
        assertNotEquals(FileReader.readLines(FILE1), list2);
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
