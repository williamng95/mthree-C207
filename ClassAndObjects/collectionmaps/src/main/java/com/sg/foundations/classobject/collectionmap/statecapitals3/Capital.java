package com.sg.foundations.classobject.collectionmap.statecapitals3;

public class Capital {
    private String name;
    private int population;
    private double area;

    public Capital(String name, int population, double area) {
        this.name = name;
        this.population = population;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public double getArea() {
        return area;
    }
}
