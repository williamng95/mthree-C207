package com.sg.classobjects.classmodelling.Airplane;
// a simple ariplane for air traffic control
// speed, location, height only

public class AirplaneATCS {
    private double speed, height;
    private String name;
    private double[] coordinates;
    public AirplaneATCS(double speed, double height, String name, double[] coordinates) {
        this.speed = speed;
        this.height = height;
        this.name = name;
        this.coordinates = coordinates;
    }
    public double getSpeed() {
        return speed;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double[] getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }
    

}
