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

    // generic object things

    /* hashcode
     * @see java.lang.Object#hashCode()
     */
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((VIN == null) ? 0 : VIN.hashCode());
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        result = prime * result + ((make == null) ? 0 : make.hashCode());
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        result = prime * result + (int) (odometerMiles ^ (odometerMiles >>> 32));
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        return result;
    }

    /* equals for comparison
     * @see java.lang.Object#equals(java.lang.Object)
     */
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Car other = (Car) obj;
        if (VIN == null) {
            if (other.VIN != null)
                return false;
        } else if (!VIN.equals(other.VIN))
            return false;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        if (key == null) {
            if (other.key != null)
                return false;
        } else if (!key.equals(other.key))
            return false;
        if (make == null) {
            if (other.make != null)
                return false;
        } else if (!make.equals(other.make))
            return false;
        if (model == null) {
            if (other.model != null)
                return false;
        } else if (!model.equals(other.model))
            return false;
        if (odometerMiles != other.odometerMiles)
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        return true;
    }

    /* String rep of object
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        return "Car [VIN=" + VIN + ", color=" + color + ", key=" + key + ", make=" + make + ", model=" + model
                + ", odometerMiles=" + odometerMiles + ", price=" + price + "]";
    }

    

    

}
