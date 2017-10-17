package org.martinyuk.sphere.action;

import org.martinyuk.sphere.entity.Point;
import org.martinyuk.sphere.entity.Sphere;
import org.martinyuk.sphere.util.PointIdGenerator;
import org.martinyuk.sphere.util.SphereIdGenerator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class SphereCalculateActionTest {

    private Point point1;

    private Sphere sphere1;
    private Sphere sphere2;

    private double result1;
    private double result2;
    private double accuracy;

    private SphereCalculateAction action = SphereCalculateAction.getInstance();


    @BeforeClass
    public void setUp() {

        SphereIdGenerator.startTest();
        PointIdGenerator.startTest();

        point1 = new Point(3, 3, 3);
        accuracy = 0.00001;
        result1 = 113.09733552923255;
        result2 = 5.4D;
        sphere1 = new Sphere(point1, 3);
        sphere2 = new Sphere(point1, 6);
    }

    @AfterClass
    public void tearDown() {
        SphereIdGenerator.stopTest();
        PointIdGenerator.stopTest();
    }

    @Test
    public void calculateVolumeTrueTest() {
        assertEquals(action.calculateVolume(sphere1), result1, accuracy);
    }

    @Test
    public void calculateVolumeNotEqualsTest() {
        assertNotEquals(action.calculateVolume(sphere2), result1, accuracy);
    }

    @Test
    public void calculateSurfaceAreaTrueTest() {
        assertEquals(action.calculateSurfaceArea(sphere1), result1, accuracy);
    }

    @Test
    public void calculateSurfaceAreaNotEqualsTest() {
        assertNotEquals(action.calculateSurfaceArea(sphere2), result1, accuracy);
    }

    @Test
    public void calculateVolumeRatioRelativelyPlaneXYTest() {
        assertEquals(action.volumeRatioRelativelyPlaneXY(sphere2), result2, accuracy);
    }

    @Test
    public void calculateVolumeRatioRelativelyPlaneXZTest() {
        assertEquals(action.volumeRatioRelativelyPlaneXZ(sphere2), result2, accuracy);
    }

    @Test
    public void calculateVolumeRatioRelativelyPlaneYZTest() {
        assertEquals(action.volumeRatioRelativelyPlaneYZ(sphere2), result2, accuracy);
    }
}
