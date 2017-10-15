package by.martinyuk.sphere.factory;

import by.martinyuk.sphere.entity.AbstractEntity;


public class EntityFactory {

    private EntityFactory() {
    }

    public static AbstractEntity factoryMethod(FactoryEntityType type) {
        return type.create();
    }

}
