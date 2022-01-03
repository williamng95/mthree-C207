package com.sg.classobject.inheritance;

public class Ellipse implements Shape {
    private double majorRadius, minorRadius;

    protected double perimeter, area;

    public Ellipse(double majorRadius, double minorRadius) {
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;

        this.recalculate();
    }

    private void recalculate() {
        this.setPerimeter();
        this.setArea();
    }

    public double getMajorRadius() {
        return majorRadius;
    }

    public void setMajorRadius(double majorRadius) {
        this.majorRadius = majorRadius;
        this.recalculate();
    }

    public double getMinorRadius() {
        return minorRadius;
    }

    public void setMinorRadius(double minorRadius) {
        this.minorRadius = minorRadius;
        this.recalculate();
    }

    public void setPerimeter() {
        // Ramanujan's approximation; resolves exactly for circles.
        double h = Math.pow((this.majorRadius - this.minorRadius) / (this.majorRadius + this.minorRadius), 2);
        this.perimeter = Math.PI * (this.majorRadius + this.minorRadius) * (1 + (3 * h) / (10 + Math.sqrt(4 - 3 * h)));
    }

    public void setArea() {
        this.area = Math.PI * this.majorRadius * this.minorRadius;
    }

    @Override
    public double getArea() {
        return this.area;
    }

    @Override
    public double getPerimeter() {
        return this.perimeter;
    }

}
