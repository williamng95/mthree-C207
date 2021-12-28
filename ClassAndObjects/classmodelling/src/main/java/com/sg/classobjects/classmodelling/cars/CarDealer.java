package com.sg.classobjects.classmodelling.cars;
// a simple class for tracking cars in a dealer's inventory

// basic parameters such as make and model of car, and price.

import java.time.LocalDate;

public class CarDealer {
    private String brandName, modelName, carPlate, carStyle;
    private LocalDate manufactureDate;
    private int carID;
    private double salePrice;

    public CarDealer(String brandName, String modelName, String carPlate, String carStyle, LocalDate manufactureDate,
            int carID, double salePrice) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.carPlate = carPlate;
        this.carStyle = carStyle;
        this.manufactureDate = manufactureDate;
        this.carID = carID;
        this.salePrice = salePrice;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public String getCarStyle() {
        return carStyle;
    }

    public void setCarStyle(String carStyle) {
        this.carStyle = carStyle;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

}
