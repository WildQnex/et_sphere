package by.martinyuk.sphere.action;

import by.martinyuk.sphere.entity.AbstractEntity;
import by.martinyuk.sphere.entity.Sphere;

public class SphereCheckAction {

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
        return Math.abs(sphere.getCenter().getZ()) == sphere.getRadius();
    }

    public boolean isSphereTouchesPlaneXZ(Sphere sphere) {
        return Math.abs(sphere.getCenter().getY()) == sphere.getRadius();
    }

    public boolean isSphereTouchesPlaneYZ(Sphere sphere) {
        return Math.abs(sphere.getCenter().getX()) == sphere.getRadius();
    }

    private static class SingletonHolder {
        private static final SphereCheckAction INSTANCE;

        static {
            try {
                INSTANCE = new SphereCheckAction();
            } catch (Exception e) {
                throw new ExceptionInInitializerError(e);
            }
        }
    }
}
