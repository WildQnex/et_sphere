package by.martinyuk.et_shape.dao;

import by.martinyuk.et_sphere.dao.FileDao;
import by.martinyuk.et_sphere.dao.exception.DaoException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;


import java.util.ArrayList;
import java.util.List;

import static by.martinyuk.et_sphere.dao.FileDao.getData;
import static org.testng.Assert.*;

public class FileDaoTest {

    private final Logger LOGGER = LogManager.getLogger(FileDaoTest.class);
    private final String FILE1 = "data/data.txt";
    private final String FILE2 = "data.txt";

    private String errorMessage;

    private List<String> list1 = new ArrayList<>();
    private List<String> list2 = new ArrayList<>();

    @BeforeClass
    public void setup(){
        errorMessage = "File wasn't found";

        list1.add("2.5 6.3 6.1 3.6");
        list1.add("4.2 5.2 4.3 6.2");
        list1.add("3.4 5.7 8.2 9.0");

        list2.add("2.1 6.3 6.1 3.6");
        list2.add("4.2 5.2 1.3 6.2");
        list2.add("3.4 5.1 8.2 9.0");

    }

    @Test
    public void getDataTest(){
        try {
            assertEquals(getData(FILE1), list1);
        }catch (DaoException e){
            LOGGER.log(Level.ERROR, e.getMessage());
        }
    }

    @Test
    public void getDataNotEqualsTest(){
        try {
            assertNotEquals(getData(FILE1), list2);
        }catch (DaoException e){
            LOGGER.log(Level.ERROR, e.getMessage());
        }
    }

    @Test(expectedExceptions = DaoException.class)
    public void getDataFileNotFoundTest() throws DaoException{
            FileDao.getData(FILE2);
    }

    @Test
    public void getDataErrorMessageTest(){
        try{
            FileDao.getData(FILE2);
        }catch (DaoException e) {
            assertEquals(e.getMessage(), errorMessage);
        }

    }
}
