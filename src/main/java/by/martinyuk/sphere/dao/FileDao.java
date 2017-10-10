package by.martinyuk.sphere.dao;

import by.martinyuk.sphere.dao.exception.DaoException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileDao {

    private FileDao(){

    }

    public static List<String> getData(String filePath) throws DaoException {
        List<String> list = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filePath);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        }catch (FileNotFoundException e){
            throw new DaoException("File wasn't found");
        } catch (IOException e){
            throw new DaoException("Can't open file");
        }
        return list;
    }
}
