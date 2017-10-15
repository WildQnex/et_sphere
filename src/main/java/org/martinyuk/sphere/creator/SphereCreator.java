package org.martinyuk.sphere.creator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.martinyuk.sphere.cache.SphereCache;
import org.martinyuk.sphere.entity.Point;
import org.martinyuk.sphere.entity.Sphere;
import org.martinyuk.sphere.exception.FactoryException;
import org.martinyuk.sphere.factory.EntityFactory;

import java.util.List;

public final class SphereCreator {

    private SphereCreator() {
    }

    private static final Logger LOGGER = LogManager.getLogger(SphereCache.class);

    public static Sphere createSphere(List<Double> list) {
        if (list.size() != 4) {
            return null;
        }
        try {
            Sphere sphere = (Sphere) EntityFactory.factoryMethod("Sphere");
            Point center = (Point) EntityFactory.factoryMethod("Point");

            center.setX(list.get(0));
            center.setY(list.get(1));
            center.setZ(list.get(2));

            sphere.setCenter(center);
            sphere.setRadius(list.get(3));

            return sphere;
        } catch (FactoryException e) {
            LOGGER.log(Level.ERROR, "Can't create object");
        }
        return null;
    }
}
