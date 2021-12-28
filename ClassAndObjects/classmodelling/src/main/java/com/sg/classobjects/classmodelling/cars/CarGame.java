package com.sg.classobjects.classmodelling.cars;
// simple, non-physical car class model for racing game

// models constant accleration until top speed. 

public class CarGame {
    private double xSpeed, ySpeed, topSpeed, acceleration;
    private int gearUse, maxGear;

    public CarGame(double xSpeed, double ySpeed, double topSpeed, double acceleration, int gearUse, int maxGear) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.topSpeed = topSpeed;
        this.acceleration = acceleration;
        this.gearUse = gearUse;
        this.maxGear = maxGear;
    }

    public double getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public double getySpeed() {
        return ySpeed;
    }

    public void setySpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(double topSpeed) {
        this.topSpeed = topSpeed;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public int getGearUse() {
        return gearUse;
    }

    public void setGearUse(int gearUse) {
        this.gearUse = gearUse;
    }

    public int getMaxGear() {
        return maxGear;
    }

    public void setMaxGear(int maxGear) {
        this.maxGear = maxGear;
    }

    public void accelerate(double accleratePercent, double direction) {
        this.xSpeed += this.acceleration * accleratePercent * direction;
        this.ySpeed += this.acceleration * accleratePercent * (1 - direction);
    }

}
