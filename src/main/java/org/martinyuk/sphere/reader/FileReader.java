package org.martinyuk.sphere.reader;

import org.martinyuk.sphere.exception.FileReaderException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    private FileReader() {
    }

    public static List<String> readLines(String filePath) throws FileReaderException {

        List<String> list = new ArrayList<>();

        try {
            Files.lines(Paths.get(filePath)).forEach(list::add);
        } catch (NoSuchFileException e) {
            throw new FileReaderException("File wasn't found, file path = " + filePath, e);
        } catch (IOException e) {
            throw new FileReaderException("Can't open file, file path = " + filePath, e);
        }

        return list;
    }

}
