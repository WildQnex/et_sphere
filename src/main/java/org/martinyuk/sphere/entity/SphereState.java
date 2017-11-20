package org.martinyuk.sphere.entity;

public class SphereState {

    private double volume;
    private double square;

    public SphereState() {
    }

    public double getVolume() {
        return volume;
    }

    public double getSquare() {
        return square;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SphereState that = (SphereState) o;

        if (Double.compare(that.volume, volume) != 0) return false;
        return Double.compare(that.square, square) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(volume);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(square);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
