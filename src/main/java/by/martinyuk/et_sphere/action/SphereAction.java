package by.martinyuk.et_sphere.action;

import by.martinyuk.et_sphere.entity.AbstractShape;
import by.martinyuk.et_sphere.entity.Sphere;

public class SphereAction {

    public static double calculateSurfaceArea(Sphere sphere){
        return 4 * Math.PI * Math.pow(sphere.getRadius(), 2);
    }

    public static double calculateSurfaceArea(double radius){
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    public static double calculateVolume(Sphere sphere){
        return 4 * Math.PI * Math.pow(sphere.getRadius(), 3) / 3;
    }

    public static double calculateVolume(double radius){
        return 4 * Math.PI * Math.pow(radius, 3) / 3;
    }

    public static boolean isSphere(AbstractShape shape){
        if(shape instanceof Sphere){
            return ((Sphere) shape).getRadius() > 0;
        }else{
            return false;
        }
    }

    public static boolean isSphereTouchesPlaneXY(Sphere sphere){
        return Math.abs(sphere.getCenter().getZ()) == 0;
    }

    public static boolean isSphereTouchesPlaneXZ(Sphere sphere){
        return Math.abs(sphere.getCenter().getY()) == 0;
    }

    public static boolean isSphereTouchesPlaneYZ(Sphere sphere){
        return Math.abs(sphere.getCenter().getX()) == 0;
    }

    public static double volumeRatioRelativelyPlaneXY(Sphere sphere){

        if (Math.abs(sphere.getCenter().getZ()) - sphere.getRadius() >= 0){
            if(sphere.getCenter().getZ() > 0) {
                return 0;
            } else {
                return -1;
            }
        }

        return calculateSegmentRatio(sphere.getCenter().getZ(), sphere.getRadius());
    }

    public static double volumeRatioRelativelyPlaneXZ(Sphere sphere){

        if (Math.abs(sphere.getCenter().getY()) - sphere.getRadius() >= 0){
            if(sphere.getCenter().getY() > 0) {
                return 0;
            } else {
                return -1;
            }
        }

        return calculateSegmentRatio(sphere.getCenter().getY(), sphere.getRadius());
    }

    public static double volumeRatioRelativelyPlaneYZ(Sphere sphere){

        if (Math.abs(sphere.getCenter().getX()) - sphere.getRadius() >= 0){
            if(sphere.getCenter().getX() > 0) {
                return 0;
            } else {
                return -1;
            }
        }

        return calculateSegmentRatio(sphere.getCenter().getX(), sphere.getRadius());
    }

    private static double calculateSegmentRatio(double center, double radius){

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
