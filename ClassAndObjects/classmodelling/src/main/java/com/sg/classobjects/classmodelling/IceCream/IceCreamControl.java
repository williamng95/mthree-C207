package com.sg.classobjects.classmodelling.icecream;
// basic ice cream churning parameters only

public class IceCreamControl {
    private double temperature, churnSpeed, weight, airPercent, churnTime;
    private int numChurns;
    public IceCreamControl(double temperature, double churnSpeed, double weight, double airPercent, double churnTime,
            int numChurns) {
        this.temperature = temperature;
        this.churnSpeed = churnSpeed;
        this.weight = weight;
        this.airPercent = airPercent;
        this.churnTime = churnTime;
        this.numChurns = numChurns;
    }
    public double getTemperature() {
        return temperature;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    public double getChurnSpeed() {
        return churnSpeed;
    }
    public void setChurnSpeed(double churnSpeed) {
        this.churnSpeed = churnSpeed;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getAirPercent() {
        return airPercent;
    }
    public void setAirPercent(double airPercent) {
        this.airPercent = airPercent;
    }
    public double getChurnTime() {
        return churnTime;
    }
    public void setChurnTime(double churnTime) {
        this.churnTime = churnTime;
    }
    public int getNumChurns() {
        return numChurns;
    }
    public void setNumChurns(int numChurns) {
        this.numChurns = numChurns;
    }
    
}
