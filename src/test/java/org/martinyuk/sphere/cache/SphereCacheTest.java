package org.martinyuk.sphere.cache;

import org.martinyuk.sphere.entity.Sphere;
import org.martinyuk.sphere.util.PointIdGenerator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
    private List<String> list = new ArrayList<>();

    @BeforeClass
    public void setUp() throws IOException {
        file = File.createTempFile("tmp", "txt");
        PointIdGenerator.startTest();
        file.deleteOnExit();
        list.add("1.1,1.2,1.3,1.4");
        list.add("2.1,-41.4,14.5,6.1");
        list.add("2.1,1.4,14.5,-6.1");
        list.add("-1.2,4.1,15.1,5");
        try (FileWriter fileWriter = new FileWriter(file.getAbsolutePath());
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (String line : list) {
                bufferedWriter.write(line + "\n");
            }
        }
        SphereCache.initFilePath(file.getAbsolutePath());
        cache = SphereCache.getInstance();
    }


    @AfterMethod
    public void restoreData() {
        if (cache.readAll().size() == 2) {
            cache.create(new Sphere(-1.2, 4.1, 15.1, 5, 3));
        }
        if (cache.readAll().stream().anyMatch(s -> s.getRadius() == 10D)) {
            cache.update(new Sphere(1.1, 1.2, 1.3, 1.4, 1));
        }
        if (cache.readAll().size() == 4) {
            cache.delete(4);
        }
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
    }

    @Test
    public void deleteTest() {
        cache.delete(3);
        List<Sphere> result = new ArrayList<>();
        result.add(new Sphere(1.1, 1.2, 1.3, 1.4, 1));
        result.add(new Sphere(2.1, -41.4, 14.5, 6.1, 2));
        assertEquals(cache.readAll(), result);
    }

    @Test
    public void createTest() {
        cache.create(new Sphere(2.1, 1.4, 14.5, -6.1, 4));
        List<Sphere> result = new ArrayList<>();
        result.add(new Sphere(1.1, 1.2, 1.3, 1.4, 1));
        result.add(new Sphere(2.1, -41.4, 14.5, 6.1, 2));
        result.add(new Sphere(-1.2, 4.1, 15.1, 5, 3));
        result.add(new Sphere(2.1, 1.4, 14.5, -6.1, 4));
        assertEquals(cache.readAll(), result);
    }
}

