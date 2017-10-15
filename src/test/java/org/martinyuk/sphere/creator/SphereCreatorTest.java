package org.martinyuk.sphere.creator;

import org.martinyuk.sphere.entity.Sphere;
import org.martinyuk.sphere.util.PointIdGenerator;
import org.martinyuk.sphere.util.SphereIdGenerator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class SphereCreatorTest {

    @BeforeClass
    public void setUp() {
        PointIdGenerator.startTest();
        SphereIdGenerator.startTest();

    }

    @AfterClass
    public void tearDown(){
        PointIdGenerator.stopTest();
        SphereIdGenerator.stopTest();
    }

    @Test
    public void createSphereTest() {
        List<Double> list = new ArrayList<>();
        list.add(12.4);
        list.add(-1D);
        list.add(0D);
        list.add(5.5);
        Sphere result = new Sphere(12.4, -1D, 0D, 5.5);
        assertEquals(SphereCreator.createSphere(list), result);
    }

    @Test
    public void createSphereAnotherTest() {
        List<Double> list = new ArrayList<>();
        list.add(-13.644);
        list.add(-155.345);
        list.add(41D);
        list.add(552.5);
        Sphere result = new Sphere(-13.644, -155.345, 41D, 552.5);
        assertEquals(SphereCreator.createSphere(list), result);
    }

    @Test
    public void createSphereNotEnoughParametersTest() {
        List<Double> list = new ArrayList<>();
        list.add(-13.644);
        list.add(-155.345);
        list.add(41D);
        assertNull(SphereCreator.createSphere(list));
    }

    @Test
    public void createSphereTooMuchParametersTest() {
        List<Double> list = new ArrayList<>();
        list.add(12.4);
        list.add(-1D);
        list.add(-13.644);
        list.add(-155.345);
        list.add(41D);
        assertNull(SphereCreator.createSphere(list));
    }
}