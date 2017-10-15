package by.martinyuk.sphere.action;

import by.martinyuk.sphere.entity.Point;
import by.martinyuk.sphere.entity.Sphere;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SphereCheckActionTest {

    private Point point1;

    private Sphere sphere1;
    private Sphere sphere2;

    private SphereCheckAction action = SphereCheckAction.getInstance();

    @BeforeClass
    public void setup() {
        point1 = new Point(3, 3, 3);
        sphere1 = new Sphere(point1, 3);
        sphere2 = new Sphere(point1, 4);
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
