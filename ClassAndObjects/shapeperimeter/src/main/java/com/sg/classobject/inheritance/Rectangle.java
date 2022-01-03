package com.sg.classobject.inheritance;

public class Rectangle extends Polygon {
    protected double width, height;

    public Rectangle(double width, double height) {
        super(new double[] { width, height, width, height });
        this.width = width;
        this.height = height;
        this.setArea();
    }

    @Override
    public void setArea() {
        this.area = this.width * this.height;
    }

    @Override
    public double getArea() {
        System.out.printf("Area of shape: %f%n", this.area);
        return this.area;
    }
}
