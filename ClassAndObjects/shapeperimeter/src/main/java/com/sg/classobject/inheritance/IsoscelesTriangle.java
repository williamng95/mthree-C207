package com.sg.classobject.inheritance;

public class IsoscelesTriangle extends Triangle {

    public IsoscelesTriangle(double base, double sideLength) {
        super(new double[] { sideLength, sideLength, base });
    }
}
