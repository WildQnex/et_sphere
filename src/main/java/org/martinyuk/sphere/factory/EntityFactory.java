package org.martinyuk.sphere.factory;

import org.martinyuk.sphere.entity.AbstractEntity;
import org.martinyuk.sphere.exception.FactoryException;


public class EntityFactory {

    private EntityFactory() {
    }

    public static AbstractEntity factoryMethod(String name) throws FactoryException {
        return FactoryEntityType.create(name);
    }

}
