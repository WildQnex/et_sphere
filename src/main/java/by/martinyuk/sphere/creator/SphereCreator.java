package by.martinyuk.sphere.creator;

import by.martinyuk.sphere.entity.Point;
import by.martinyuk.sphere.entity.Sphere;
import by.martinyuk.sphere.factory.EntityFactory;
import by.martinyuk.sphere.factory.FactoryEntityType;

import java.util.List;

public class SphereCreator {
    public static Sphere createSphere(List<Double> list) {
        Sphere sphere = (Sphere) EntityFactory.factoryMethod(FactoryEntityType.SPHERE);
        Point center = (Point) EntityFactory.factoryMethod(FactoryEntityType.POINT);

        center.setX(list.get(0));
        center.setY(list.get(1));
        center.setZ(list.get(2));

        sphere.setCenter(center);
        sphere.setRadius(list.get(3));

        return sphere;
    }
}
