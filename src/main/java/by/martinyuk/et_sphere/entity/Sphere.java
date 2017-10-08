package by.martinyuk.et_sphere.entity;

public class Sphere extends AbstractShape {

    private Point center;
    private double radius;

    public Sphere(Point center, double radius){
        this.center = center;
        this.radius = radius;
    }

    public Sphere(double centerX, double centerY, double centerZ, double radius){
        this.center = new Point(centerX, centerY, centerZ);
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sphere sphere = (Sphere) o;

        if (Double.compare(sphere.radius, radius) != 0) return false;
        return center != null ? center.equals(sphere.center) : sphere.center == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = center != null ? center.hashCode() : 0;
        temp = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Sphere (Central " + center +
                ", radius = " + radius + ')';
    }
}
