package com.sg.classobjects.classmodelling.airplanes;
// a simple aircraft model class for simulator.
// only describes how the aircraft is positioned and speed.
// a method included to 'accelerate' plane

public class AirplaneSim {
    private double xSpeed, ySpeed, zSpeed, height, yaw, pitch, roll;
    private String name;
    public AirplaneSim(double xSpeed, double ySpeed, double zSpeed, double height, double yaw, double pitch,
            double roll, String name) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.zSpeed = zSpeed;
        this.height = height;
        this.yaw = yaw;
        this.pitch = pitch;
        this.roll = roll;
        this.name = name;
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
    public double getzSpeed() {
        return zSpeed;
    }
    public void setzSpeed(double zSpeed) {
        this.zSpeed = zSpeed;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getYaw() {
        return yaw;
    }
    public void setYaw(double yaw) {
        this.yaw = yaw;
    }
    public double getPitch() {
        return pitch;
    }
    public void setPitch(double pitch) {
        this.pitch = pitch;
    }
    public double getRoll() {
        return roll;
    }
    public void setRoll(double roll) {
        this.roll = roll;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void accelerate(double xAcceleration,double yAcceleration,double zAcceleration) {
        this.xSpeed+=xAcceleration;
        this.ySpeed+=yAcceleration;
        this.zSpeed+=zAcceleration;
    }
}
