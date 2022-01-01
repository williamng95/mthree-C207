package com.sg.classobject.inheritance;

public class Rectangle extends Polygon {
    protected double width, height;

    public Rectangle(double width, double height) {
        super(new double[] { width, height, width, height });
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return this.width * this.height;
    }
}
