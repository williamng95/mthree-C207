package com.sg.classobject.inheritance;

public class Triangle extends Polygon {

    public Triangle(double[] sideList) {
        super(sideList);
    }

    public Triangle(double sideLength) {
        // overload for equilateral triangle
        super(new double[] { sideLength, sideLength, sideLength });
    }

    @Override
    public double getArea() {
        // heron's formula
        double s = this.getPerimeter()/2;
        double area = Math.sqrt(s);
        for (double d : this.sideList) {
            area *= Math.sqrt((s - d));
        }
        return area;
    }

}
