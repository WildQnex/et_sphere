package by.martinyuk.sphere.factory;

import by.martinyuk.sphere.entity.AbstractEntity;
import by.martinyuk.sphere.entity.Point;
import by.martinyuk.sphere.entity.Sphere;
import by.martinyuk.sphere.exception.FactoryException;

import java.util.List;

public class EntityFactory {

    private EntityFactory() {
    }

    public static AbstractEntity factoryMethod(List<Double> list) throws FactoryException {
        AbstractEntity entity;
        switch (list.size()) {
            case 3:
                entity = pointCreator(list);
                break;
            case 4:
                entity = sphereCreator(list);
                break;
            default:
                throw new FactoryException("Wrong parameters amount, amount = " + list.size());
        }
        return entity;
    }

    private static Sphere sphereCreator(List<Double> list) {
        Double[] numbers = list.toArray(new Double[list.size()]);
        return new Sphere(numbers[0], numbers[1], numbers[2], numbers[3]);
    }

    private static Point pointCreator(List<Double> list) {
        Double[] numbers = list.toArray(new Double[list.size()]);
        return new Point(numbers[0], numbers[1], numbers[2]);
    }
}
