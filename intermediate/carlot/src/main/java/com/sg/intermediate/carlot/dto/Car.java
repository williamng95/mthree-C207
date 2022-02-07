package com.sg.intermediate.carlot.dto;

import java.math.BigDecimal;

public class Car {
    private String VIN;
    private String make;
    private String model;
    private String color;

    private BigDecimal price;
    private long odometerMiles;

    private CarKey key;

    // constructor
    /**
     * @param vIN
     * @param make
     * @param model
     * @param color
     * @param price
     * @param odometerMiles
     * @param key
     */
    public Car(String vIN, String make, String model, String color, BigDecimal price, long odometerMiles, CarKey key) {
        VIN = vIN;
        this.make = make;
        this.model = model;
        this.color = color;
        this.price = price;
        this.odometerMiles = odometerMiles;
        this.key = key;
    }

    // plus getters, setters
    /**
     * @return the vIN
     */
    public String getVIN() {
        return VIN;
    }

    /**
     * @param vIN the vIN to set
     */
    public void setVIN(String vIN) {
        VIN = vIN;
    }

    /**
     * @return the make
     */
    public String getMake() {
        return make;
    }

    /**
     * @param make the make to set
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return the odometerMiles
     */
    public long getOdometerMiles() {
        return odometerMiles;
    }

    /**
     * @param odometerMiles the odometerMiles to set
     */
    public void setOdometerMiles(long odometerMiles) {
        this.odometerMiles = odometerMiles;
    }

    /**
     * @return the key
     */
    public CarKey getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(CarKey key) {
        this.key = key;
    }

}
