package by.martinyuk.sphere.action;

import by.martinyuk.sphere.entity.AbstractShape;
import by.martinyuk.sphere.entity.Sphere;

public class SphereAction {

    private SphereAction() {
    }

    public static SphereAction getInstance(){
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder{
        private static final SphereAction INSTANCE;
        static {
            try {
                INSTANCE = new SphereAction();
            } catch (Exception e) {
                throw new ExceptionInInitializerError(e);
            }
        }
    }

    public double calculateSurfaceArea(Sphere sphere){
        return 4 * Math.PI * Math.pow(sphere.getRadius(), 2);
    }

    public double calculateSurfaceArea(double radius){
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    public double calculateVolume(Sphere sphere){
        return 4 * Math.PI * Math.pow(sphere.getRadius(), 3) / 3;
    }

    public double calculateVolume(double radius){
        return 4 * Math.PI * Math.pow(radius, 3) / 3;
    }

    public boolean isSphere(AbstractShape shape){
        if(shape instanceof Sphere){
            return ((Sphere) shape).getRadius() > 0;
        }else{
            return false;
        }
    }

    public boolean isSphereTouchesPlaneXY(Sphere sphere){
        return Math.abs(sphere.getCenter().getZ()) == 0;
    }

    public boolean isSphereTouchesPlaneXZ(Sphere sphere){
        return Math.abs(sphere.getCenter().getY()) == 0;
    }

    public boolean isSphereTouchesPlaneYZ(Sphere sphere){
        return Math.abs(sphere.getCenter().getX()) == 0;
    }

    public double volumeRatioRelativelyPlaneXY(Sphere sphere){

        if (Math.abs(sphere.getCenter().getZ()) - sphere.getRadius() >= 0){
            if(sphere.getCenter().getZ() > 0) {
                return 0;
            } else {
                return -1;
            }
        }

        return calculateSegmentRatio(sphere.getCenter().getZ(), sphere.getRadius());
    }

    public double volumeRatioRelativelyPlaneXZ(Sphere sphere){

        if (Math.abs(sphere.getCenter().getY()) - sphere.getRadius() >= 0){
            if(sphere.getCenter().getY() > 0) {
                return 0;
            } else {
                return -1;
            }
        }

        return calculateSegmentRatio(sphere.getCenter().getY(), sphere.getRadius());
    }

    public double volumeRatioRelativelyPlaneYZ(Sphere sphere){

        if (Math.abs(sphere.getCenter().getX()) - sphere.getRadius() >= 0){
            if(sphere.getCenter().getX() > 0) {
                return 0;
            } else {
                return -1;
            }
        }

        return calculateSegmentRatio(sphere.getCenter().getX(), sphere.getRadius());
    }

    private double calculateSegmentRatio(double center, double radius){

        double positiveHeight;

        if(center > 0){
            positiveHeight = radius + center;
        } else {
            positiveHeight = radius - center;
        }

        double positiveSegmentVolume = Math.PI * Math.pow(positiveHeight, 2) * (radius - positiveHeight / 3);

        return positiveSegmentVolume / (calculateVolume(radius) - positiveSegmentVolume);
    }
}
