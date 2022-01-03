package com.sg.classobject.inheritance;

public class RightAngleTriangle extends Triangle {
    protected double hypotenuse;
    public RightAngleTriangle(double width, double height) {
        super(new double[] {width, height, Math.hypot(width, height)});
    }

}
