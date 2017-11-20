package org.martinyuk.sphere.action;

import org.martinyuk.sphere.entity.Sphere;


public class SphereCalculateAction {

    private static final double VOLUME_MULTIPLIER = 4D / 3D;

    private static final int SURFACE_AREA_EXPONENT = 2;
    private static final int VOLUME_EXPONENT = 3;

    private SphereCalculateAction() {
    }

    public double calculateSurfaceArea(Sphere sphere) {
        final double SURFACE_AREA_MULTIPLIER = 4D;
        return SURFACE_AREA_MULTIPLIER * Math.PI * Math.pow(sphere.getRadius(), SURFACE_AREA_EXPONENT);
    }

    public double calculateVolume(Sphere sphere) {
        return Math.PI * Math.pow(sphere.getRadius(), VOLUME_EXPONENT) * VOLUME_MULTIPLIER;
    }

    public double volumeRatioRelativelyPlaneXY(Sphere sphere) {

        if (Math.abs(sphere.getCenter().getZ()) - sphere.getRadius() >= 0) {
            if (sphere.getCenter().getZ() > 0) {
                return 0;
            } else {
                return -1;
            }
        }

        return calculateSegmentRatio(sphere.getCenter().getZ(), sphere.getRadius());
    }

    public double volumeRatioRelativelyPlaneXZ(Sphere sphere) {

        if (Math.abs(sphere.getCenter().getY()) - sphere.getRadius() >= 0) {
            if (sphere.getCenter().getY() > 0) {
                return 0;
            } else {
                return -1;
            }
        }

        return calculateSegmentRatio(sphere.getCenter().getY(), sphere.getRadius());
    }

    public double volumeRatioRelativelyPlaneYZ(Sphere sphere) {

        if (Math.abs(sphere.getCenter().getX()) - sphere.getRadius() >= 0) {
            if (sphere.getCenter().getX() > 0) {
                return 0;
            } else {
                return -1;
            }
        }

        return calculateSegmentRatio(sphere.getCenter().getX(), sphere.getRadius());
    }

    private double calculateSegmentRatio(double center, double radius) {

        double positiveHeight;

        if (center > 0) {
            positiveHeight = radius + center;
        } else {
            positiveHeight = radius - center;
        }
        final double SEGMENT_VOLUME_DIVIDER = 3D;
        double positiveSegmentVolume = Math.PI * Math.pow(positiveHeight, SURFACE_AREA_EXPONENT) *
                (radius - positiveHeight / SEGMENT_VOLUME_DIVIDER);

        return positiveSegmentVolume / (calculateVolume(radius) - positiveSegmentVolume);
    }

    private double calculateVolume(double radius) {
        return VOLUME_MULTIPLIER * Math.PI * Math.pow(radius, VOLUME_EXPONENT);
    }

    public static SphereCalculateAction getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final SphereCalculateAction INSTANCE;

        static {
            INSTANCE = new SphereCalculateAction();
        }
    }
}
