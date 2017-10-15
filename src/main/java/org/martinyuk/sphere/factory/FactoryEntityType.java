package org.martinyuk.sphere.factory;

import org.martinyuk.sphere.entity.AbstractEntity;
import org.martinyuk.sphere.entity.Point;
import org.martinyuk.sphere.entity.Sphere;
import org.martinyuk.sphere.exception.FactoryException;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum FactoryEntityType {

    SPHERE {
        public AbstractEntity createConcrete() {
            return new Sphere();
        }
    },
    POINT {
        public AbstractEntity createConcrete() {
            return new Point();
        }
    };

    public abstract AbstractEntity createConcrete();

    public static AbstractEntity create(String name) throws FactoryException {
        if (!Arrays.stream(FactoryEntityType.values())
                .map(Enum::toString)
                .collect(Collectors.toList())
                .contains(name.toUpperCase())) {
            throw new FactoryException("There are no elements equaled to " + name);
        }
        return FactoryEntityType.valueOf(name.toUpperCase()).createConcrete();
    }
}