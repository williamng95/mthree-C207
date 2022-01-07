package com.sg.classobject.inheritance;

public class Ellipse implements Shape {
    private double majorRadius, minorRadius;


    public Ellipse(double majorRadius, double minorRadius) {
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }

    public double getMajorRadius() {
        return majorRadius;
    }

    public void setMajorRadius(double majorRadius) {
        this.majorRadius = majorRadius;
    }

    public double getMinorRadius() {
        return minorRadius;
    }

    public void setMinorRadius(double minorRadius) {
        this.minorRadius = minorRadius;
    }
    
    @Override
    public double getArea() {
        return Math.PI * this.majorRadius * this.minorRadius;
    }

    @Override
    public double getPerimeter() {
        // Ramanujan's approximation; resolves exactly for circles.
        double h = Math.pow((this.majorRadius - this.minorRadius) / (this.majorRadius + this.minorRadius), 2);
        return Math.PI * (this.majorRadius + this.minorRadius) * (1 + (3 * h) / (10 + Math.sqrt(4 - 3 * h)));
    }

}
