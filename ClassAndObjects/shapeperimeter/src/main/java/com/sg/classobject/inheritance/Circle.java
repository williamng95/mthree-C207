package com.sg.classobject.inheritance;

public class Circle extends Ellipse {
    private double radius;

    // no need to reimplement area and perimeter, ellipse equations resolve exactly
    // for circle.
    public Circle(double radius) {
        super(radius, radius);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
