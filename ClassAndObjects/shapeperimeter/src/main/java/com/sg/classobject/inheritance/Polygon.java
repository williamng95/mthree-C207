package com.sg.classobject.inheritance;

public abstract class Polygon extends Shape {
    protected int numSides;
    protected double[] sideList;

    public Polygon(double[] sideList) {

        this.sideList = sideList;
        this.numSides = sideList.length;
    }

    public abstract double getArea();

    public double getPerimeter() {
        double perimeter = 0;
        for (double d : sideList) {
            perimeter += d;
        }
        return perimeter;
    }

}
