package org.martinyuk.sphere.entity;

import org.martinyuk.sphere.util.IdGenerator;

public class Sphere extends AbstractEntity {

    private static final int DIAMETER_COEFFICIENT = 2;

    private Point center;
    private double radius;

    public Sphere() {
        super(IdGenerator.nextId());
    }

    public Sphere(Point center, double radius) {
        super(IdGenerator.nextId());
        this.center = center;
        this.radius = radius;
    }

    public Sphere(double centerX, double centerY, double centerZ, double radius) {
        super(IdGenerator.nextId());
        this.center = new Point(centerX, centerY, centerZ);
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public double getDiameter() {
        return radius * DIAMETER_COEFFICIENT;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public Sphere clone() throws CloneNotSupportedException {
        Sphere clone = (Sphere) super.clone();
        clone.center = center.clone();
        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Sphere sphere = (Sphere) o;

        if (Double.compare(sphere.radius, radius) != 0) return false;
        return center != null ? center.equals(sphere.center) : sphere.center == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (center != null ? center.hashCode() : 0);
        temp = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "SphereCalculateAction (Central " + center +
                ", radius = " + radius + ')';
    }
}
