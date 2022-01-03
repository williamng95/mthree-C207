package com.sg.classobject.inheritance;

public abstract class Polygon implements Shape {
    protected String color;
    protected int numSides;
    protected double[] sideList;
    protected double perimeter, area;

    public Polygon(double[] sideList) {

        this.sideList = sideList;
        this.numSides = sideList.length;
        this.setPerimeter();
    }
    
    public abstract void setArea();

    @Override
    public double getArea() {
        return this.area;
    };

    public void setPerimeter() {
        this.perimeter = 0;
        for (double d : sideList) {
            this.perimeter += d;
        }
    }

    @Override
    public double getPerimeter() {
        return this.perimeter;
    }

}
