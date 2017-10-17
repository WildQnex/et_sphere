package org.martinyuk.sphere.action;

import org.martinyuk.sphere.entity.AbstractEntity;
import org.martinyuk.sphere.entity.Sphere;

public class SphereCheckAction {

    private static final double ACCURACY = 0.00001;

    private SphereCheckAction() {
    }

    public static SphereCheckAction getInstance() {
        return SphereCheckAction.SingletonHolder.INSTANCE;
    }

    public boolean isSphere(AbstractEntity shape) {
        if (shape instanceof Sphere) {
            return ((Sphere) shape).getRadius() > 0;
        } else {
            return false;
        }
    }

    public boolean isSphereTouchesPlaneXY(Sphere sphere) {
        return Math.abs(Math.abs(sphere.getCenter().getZ()) - sphere.getRadius()) < ACCURACY;
    }

    public boolean isSphereTouchesPlaneXZ(Sphere sphere) {
        return Math.abs(Math.abs(sphere.getCenter().getY()) - sphere.getRadius()) < ACCURACY;
    }

    public boolean isSphereTouchesPlaneYZ(Sphere sphere) {
        return Math.abs(Math.abs(sphere.getCenter().getX()) - sphere.getRadius()) < ACCURACY;
    }

    private static class SingletonHolder {
        private static final SphereCheckAction INSTANCE;

        static {
            INSTANCE = new SphereCheckAction();
        }
    }
}
