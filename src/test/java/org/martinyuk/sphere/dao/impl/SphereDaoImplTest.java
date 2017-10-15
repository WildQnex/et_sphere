package org.martinyuk.sphere.dao.impl;

import org.martinyuk.sphere.cache.SphereCache;
import org.martinyuk.sphere.dao.SphereDao;
import org.martinyuk.sphere.entity.Sphere;
import org.martinyuk.sphere.exception.CacheException;
import org.martinyuk.sphere.util.PointIdGenerator;
import org.martinyuk.sphere.util.SphereIdGenerator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class SphereDaoImplTest {

    private File file;
    private SphereDao dao = new SphereDaoImpl();

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
                                         "-1.2,4.1,15.1,5\n" +
                                         "1.2,-4.1,1.1,3");
        }
        SphereCache.getInstance().init(file.getAbsolutePath());
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
        result.add(new Sphere(1.2, -4.1, 1.1, 3, 4));
        assertEquals(dao.readAll(), result);
    }

    @Test
    public void readAllNotEqualsTest() {
        List<Sphere> result = new ArrayList<>();
        assertNotEquals(dao.readAll(), result);
    }

    @Test
    public void readByIdTest() {
        Sphere result = new Sphere(-1.2, 4.1, 15.1, 5, 3);
        assertEquals(dao.readById(3).get(), result);
    }

    @Test
    public void readByIdNotEqualsTest() {
        Sphere result = new Sphere(-1.2, 4.1, 15.1, 5, 3);
        assertNotEquals(dao.readById(2).get(), result);
    }

    @Test
    public void updateTest() {
        Sphere sphere = dao.readById(1).get();
        sphere.setRadius(5D);
        dao.update(sphere);
        Sphere result = new Sphere(1.1, 1.2, 1.3, 5D, 1);
        assertEquals(dao.readById(1).get(), result);
        dao.update(new Sphere(1.1, 1.2, 1.3, 1.4, 1));
    }

    @Test
    public void deleteTest() {
        dao.delete(4);
        List<Sphere> result = new ArrayList<>();
        result.add(new Sphere(1.1, 1.2, 1.3, 1.4, 1));
        result.add(new Sphere(2.1, -41.4, 14.5, 6.1, 2));
        result.add(new Sphere(-1.2, 4.1, 15.1, 5, 3));
        assertEquals(dao.readAll(), result);
        dao.create(new Sphere(1.2, -4.1, 1.1, 3, 4));
    }

    @Test
    public void createTest() {
        dao.create(new Sphere(2.1, 1.4, 14.5, 6.1, 5));
        List<Sphere> result = new ArrayList<>();
        result.add(new Sphere(1.1, 1.2, 1.3, 1.4, 1));
        result.add(new Sphere(2.1, -41.4, 14.5, 6.1, 2));
        result.add(new Sphere(-1.2, 4.1, 15.1, 5, 3));
        result.add(new Sphere(1.2, -4.1, 1.1, 3, 4));
        result.add(new Sphere(2.1, 1.4, 14.5, 6.1, 5));
        assertEquals(dao.readAll(), result);
        dao.delete(5);
    }
}