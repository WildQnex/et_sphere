package by.martinyuk.sphere.action;

import by.martinyuk.sphere.entity.AbstractEntity;
import by.martinyuk.sphere.entity.Point;
import by.martinyuk.sphere.entity.Sphere;
import by.martinyuk.sphere.factory.EntityFactory;
import by.martinyuk.sphere.factory.FactoryEntityType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class SphereCalculateActionTest {

    private Point point1;

    private Sphere sphere1;
    private Sphere sphere2;
    private Sphere sphere3;

    private double value1;
    private double value2;
    private double accuracy;

    private SphereCalculateAction action = SphereCalculateAction.getInstance();

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


}
