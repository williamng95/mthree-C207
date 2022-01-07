package com.sg.classobject.inheritance;

public abstract class Polygon implements Shape {
    protected String color;
    protected int numSides;
    protected double[] sideList;

    public Polygon(double[] sideList) {

        this.sideList = sideList;
        this.numSides = sideList.length;
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public double getPerimeter() {
        double perimeter = 0;
        for (double d : sideList) {
            perimeter += d;
        }
        return perimeter;
    }

}
