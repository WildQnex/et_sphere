package by.martinyuk.sphere.dao;

import by.martinyuk.sphere.cache.Cache;
import by.martinyuk.sphere.exception.CacheException;
import by.martinyuk.sphere.entity.Sphere;
import org.testng.annotations.*;


import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class FileDaoTest {

    private final String FILE1 = "data/data.txt";
    private final String FILE2 = "data.txt";

    private String errorMessage;

    private List<Sphere> list1 = new ArrayList<>();
    private List<Sphere> list2 = new ArrayList<>();

    @BeforeClass
    public void setup(){
        errorMessage = "File wasn't found";

        list1.add(new Sphere(2.5,6.3,6.1,3.6));
        list1.add(new Sphere(4.2,5.2,4.3,6.2));
        list1.add(new Sphere(3.4,5.7,8.2,9.0));

        list2.add(new Sphere(2.1,6.3,6.1,3.6));
        list2.add(new Sphere(4.2,5.2,1.3,6.2));
        list2.add(new Sphere(3.4,5.1,8.2,9.0));

    }

    @Test
    public void getDataTest() throws CacheException{
        Cache.getInstance().readSpheres(FILE1);
        assertEquals(Cache.getInstance().getSpheres(), list1);
    }

    @Test
    public void getDataNotEqualsTest() throws CacheException{
        Cache.getInstance().readSpheres(FILE1);
        assertNotEquals(Cache.getInstance().getSpheres(), list2);
    }

    @Test(expectedExceptions = CacheException.class)
    public void getDataFileNotFoundTest() throws CacheException{
        Cache.getInstance().readSpheres(FILE2);
    }

    @Test
    public void getDataErrorMessageTest(){
        try{
            Cache.getInstance().readSpheres(FILE1);
        }catch (CacheException e) {
            assertEquals(e.getMessage(), errorMessage);
        }

    }
}
