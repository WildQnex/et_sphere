package by.martinyuk.sphere.factory;

import by.martinyuk.sphere.entity.AbstractEntity;
import by.martinyuk.sphere.entity.Point;
import by.martinyuk.sphere.entity.Sphere;

public enum FactoryEntityType {

    SPHERE {
        public AbstractEntity create() {
            return new Sphere();
        }
    },
    POINT {
        public AbstractEntity create() {
            return new Point();
        }
    };

    public abstract AbstractEntity create();

}