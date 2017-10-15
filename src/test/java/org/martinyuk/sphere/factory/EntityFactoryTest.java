package org.martinyuk.sphere.factory;

import org.martinyuk.sphere.entity.Point;
import org.martinyuk.sphere.entity.Sphere;
import org.martinyuk.sphere.exception.FactoryException;
import org.martinyuk.sphere.util.SphereIdGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class EntityFactoryTest {

    @BeforeClass
    public void setUp() {
        SphereIdGenerator.startTest();
    }

    @Test
    public void factoryMethodSphereTest() throws FactoryException {
        Sphere result = new Sphere();
        Sphere sphere = (Sphere) EntityFactory.factoryMethod("Sphere");
        assertEquals(sphere, result);
    }

    @Test
    public void factoryMethodPointTest() throws FactoryException {
        Point result = new Point();
        Point sphere = (Point) EntityFactory.factoryMethod("Point");
        assertEquals(sphere, result);
    }

    @Test(expectedExceptions = FactoryException.class)
    public void factoryMethodExceptionTest() throws FactoryException {
        EntityFactory.factoryMethod("vi");
    }
}