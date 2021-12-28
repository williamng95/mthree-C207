package com.sg.classobjects.classmodelling.IceCream;

import java.time.LocalDate;

public class IceCreamInventory {
    private String brand, flavor;
    private double netWeight, price;
    private LocalDate bestBefore;

    public IceCreamInventory(String brand, String flavor, double netWeight, double price, LocalDate bestBefore) {
        this.brand = brand;
        this.flavor = flavor;
        this.netWeight = netWeight;
        this.price = price;
        this.bestBefore = bestBefore;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public double getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(double netWeight) {
        this.netWeight = netWeight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(LocalDate bestBefore) {
        this.bestBefore = bestBefore;
    }
}
