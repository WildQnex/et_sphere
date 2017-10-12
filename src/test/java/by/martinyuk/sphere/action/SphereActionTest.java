package by.martinyuk.sphere.action;

import by.martinyuk.sphere.entity.Point;
import by.martinyuk.sphere.entity.Sphere;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SphereActionTest {

    private Point point1;

    private Sphere sphere1;
    private Sphere sphere2;
    private Sphere sphere3;

    private double value1;
    private double value2;
    private double accuracy;

    private SphereAction action = SphereAction.getInstance();

    @BeforeClass
    public void setup() {
        point1 = new Point(3, 3, 3);
        accuracy = 0.00001;
        value1 = 113.09733552923255;
        sphere1 = new Sphere(point1, 3);
        sphere2 = new Sphere(point1, 4);
    }

    @Test
    public void calculateVolumeTrueTest() {
        assertEquals(action.calculateVolume(sphere1), value1, accuracy);
    }

    @Test
    public void calculateVolumeNotEqualsTest() {
        assertNotEquals(action.calculateVolume(sphere2), value1, accuracy);
    }

    @Test
    public void calculateSurfaceAreaTrueTest() {
        assertEquals(action.calculateSurfaceArea(sphere1), value1, accuracy);
    }

    @Test
    public void calculateSurfaceAreaNotEqualsTest() {
        assertNotEquals(action.calculateSurfaceArea(sphere2), value1, accuracy);
    }

    @Test
    public void isSphereTrueTest() {
        assertTrue(action.isSphere(sphere1));
    }

    @Test
    public void isSphereFalseTest() {
        assertFalse(action.isSphere(point1));
    }

    @Test
    public void isSphereTouchesPlaneXYTrueTest() {
        assertTrue(action.isSphereTouchesPlaneXY(sphere1));
    }

    @Test
    public void isSphereTouchesPlaneXYFalseTest() {
        assertFalse(action.isSphereTouchesPlaneXY(sphere2));
    }

    @Test
    public void isSphereTouchesPlaneXZTrueTest() {
        assertTrue(action.isSphereTouchesPlaneXZ(sphere1));
    }

    @Test
    public void isSphereTouchesPlaneXZFalseTest() {
        assertFalse(action.isSphereTouchesPlaneXZ(sphere2));
    }

    @Test
    public void isSphereTouchesPlaneYZTrueTest() {
        assertTrue(action.isSphereTouchesPlaneYZ(sphere1));
    }

    @Test
    public void isSphereTouchesPlaneYZFalseTest() {
        assertFalse(action.isSphereTouchesPlaneYZ(sphere2));
    }

}
