package org.martinyuk.sphere.creator;

import org.martinyuk.sphere.entity.Sphere;

import java.util.List;

public final class SphereCreator {

    private SphereCreator() {
    }

    public static Sphere createSphere(List<Double> list) {
        final int ELEMENTS_AMOUNT = 4;
        if (list.size() != ELEMENTS_AMOUNT) {
            return null;
        }
        return new Sphere(list.get(0), list.get(1), list.get(2), list.get(3));
    }
}
