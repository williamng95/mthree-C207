package com.sg.classobject.inheritance;

public class Triangle extends Polygon {

    public Triangle(double[] sideList) {
        super(sideList);
        this.setArea();
    }

    public Triangle(double sideLength) {
        // overload for equilateral triangle
        super(new double[] { sideLength, sideLength, sideLength });
        this.setArea();
    }

    @Override
    public void setArea() {
        // heron's formula
        double s = this.getPerimeter()/2;
        this.area = Math.sqrt(s);
        for (double d : this.sideList) {
            this.area *= Math.sqrt((s - d));
        }
        
    }

}
