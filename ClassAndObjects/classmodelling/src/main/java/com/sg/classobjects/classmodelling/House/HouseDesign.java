package com.sg.classobjects.classmodelling.House;
// a simple house design class

// house design contains components that make up the house, contains an add element to array function.

// component contains list of points, with adjacency matrix describing how points are joined.
// edge pairs are organized as a list of connected pair of points. eg:[[1,2],[2,3]]

// points  are simply an array of x,y,z coordinates

public class HouseDesign {
    private Component[] componentList;
    private String name;

    public HouseDesign(Component[] componentList, String name) {
        this.componentList = componentList;
        this.name = name;
    }

    public Component[] getComponentList() {
        return componentList;
    }

    public void setComponentList(Component[] componentList) {
        this.componentList = componentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addComponent(Component[] addList) {
        Component[] newList = new Component[this.componentList.length + addList.length];
        for (int i = 0; i < this.componentList.length; i++) {
            newList[i] = this.componentList[i];
        }
        for (int i = 0; i < addList.length; i++) {
            newList[i + this.componentList.length] = addList[i];
        }
        this.componentList = newList;
    }

}

class Component {
    private Point[] pointList;
    private int[][] edgePairs;
    private String name, color;

    public Component(Point[] pointList, int[][] edgePairs, String name, String color) {
        this.pointList = pointList;
        this.edgePairs = edgePairs;
        this.name = name;
        this.color = color;
    }

    public Point[] getPointList() {
        return pointList;
    }

    public void setPointList(Point[] pointList) {
        this.pointList = pointList;
    }

    public int[][] getEdgePairs() {
        return edgePairs;
    }

    public void setEdgePairs(int[][] edgePairs) {
        this.edgePairs = edgePairs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public void addPoint(Point[] addPoint) {
        Point[] newList = new Point[this.pointList.length + addPoint.length];
        for (int i = 0; i < this.pointList.length; i++) {
            newList[i] = this.pointList[i];
        }
        for (int i = 0; i < addPoint.length; i++) {
            newList[i + this.pointList.length] = addPoint[i];
        }
        this.pointList = newList;
    }
    public void addEdge(int[][] newEdge){
        int[][] newList = new int[this.edgePairs.length + newEdge.length][];
        for (int i = 0; i < this.edgePairs.length; i++) {
            newList[i] = this.edgePairs[i];
        }
        
        for (int i = 0; i < newEdge.length; i++) {
            newList[i + this.edgePairs.length] = newEdge[i];
        }
        this.edgePairs = newList;
    }

}

class Point {
    private double xCoordinate, yCoordinate, zCoordinate;

    public Point(double xCoordinate, double yCoordinate, double zCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.zCoordinate = zCoordinate;
    }

    public double[] getCoordinates() {
        return new double[] { xCoordinate, yCoordinate, zCoordinate };
    }

    public double getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public double getzCoordinate() {
        return zCoordinate;
    }

    public void setzCoordinate(double zCoordinate) {
        this.zCoordinate = zCoordinate;
    }
}
