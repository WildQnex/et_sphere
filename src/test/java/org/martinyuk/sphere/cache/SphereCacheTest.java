package org.martinyuk.sphere.cache;

import org.martinyuk.sphere.entity.Sphere;
import org.martinyuk.sphere.exception.CacheException;
import org.martinyuk.sphere.util.PointIdGenerator;
import org.martinyuk.sphere.util.SphereIdGenerator;
import org.testng.annotations.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class SphereCacheTest {

    private File file;
    private SphereCache cache;

    @BeforeClass
    public void setUp() throws IOException, CacheException {
        file = File.createTempFile("tmp", "txt");
        PointIdGenerator.startTest();
        SphereIdGenerator.reInit();
        file.deleteOnExit();
        try (FileWriter fileWriter = new FileWriter(file.getAbsolutePath());
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                bufferedWriter.write("1.1,1.2,1.3,1.4\n" +
                                         "2.1,-41.4,14.5,6.1\n" +
                                         "2.1,1.4,14.5,-6.1\n" +
                                         "-1.2,4.1,15.1,5");

        }
        cache = SphereCache.getInstance();
        cache.init(file.getAbsolutePath());
    }

    @AfterClass
    public void tearDown(){
        PointIdGenerator.stopTest();
    }

    @Test
    public void readAllTest() {
        List<Sphere> result = new ArrayList<>();
        result.add(new Sphere(1.1, 1.2, 1.3, 1.4, 1));
        result.add(new Sphere(2.1, -41.4, 14.5, 6.1, 2));
        result.add(new Sphere(-1.2, 4.1, 15.1, 5, 3));
        assertEquals(cache.readAll(), result);
    }

    @Test
    public void readAllNotEqualsTest() {
        List<Sphere> result = new ArrayList<>();
        assertNotEquals(cache.readAll(), result);
    }

    @Test
    public void readByIdTest() {
        Sphere result = new Sphere(2.1, -41.4, 14.5, 6.1, 2);
        assertEquals(cache.readById(2).get(), result);
    }

    @Test
    public void readByIdNotEqualsTest() {
        Sphere result = new Sphere(1.1, 1.2, 1.3, 1.4, 1);
        assertNotEquals(cache.readById(2).get(), result);
    }

    @Test
    public void updateTest() {
        Sphere sphere = cache.readById(1).get();
        sphere.setRadius(10D);
        cache.update(sphere);
        Sphere result = new Sphere(1.1, 1.2, 1.3, 10D, 1);
        assertEquals(cache.readById(1).get(), result);
        cache.update(new Sphere(1.1, 1.2, 1.3, 1.4, 1));
    }

    @Test
    public void deleteTest() {
        cache.delete(3);
        List<Sphere> result = new ArrayList<>();
        result.add(new Sphere(1.1, 1.2, 1.3, 1.4, 1));
        result.add(new Sphere(2.1, -41.4, 14.5, 6.1, 2));
        assertEquals(cache.readAll(), result);
        cache.create(new Sphere(-1.2, 4.1, 15.1, 5, 3));
    }

    @Test
    public void createTest() {
        cache.create(new Sphere(2.1, 1.4, 14.5, 6.1, 4));
        List<Sphere> result = new ArrayList<>();
        result.add(new Sphere(1.1, 1.2, 1.3, 1.4, 1));
        result.add(new Sphere(2.1, -41.4, 14.5, 6.1, 2));
        result.add(new Sphere(-1.2, 4.1, 15.1, 5, 3));
        result.add(new Sphere(2.1, 1.4, 14.5, 6.1, 4));
        assertEquals(cache.readAll(), result);
        cache.delete(4);
    }
}

