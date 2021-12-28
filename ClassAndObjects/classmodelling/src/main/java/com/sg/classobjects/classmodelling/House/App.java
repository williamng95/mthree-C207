package com.sg.classobjects.classmodelling.House;

import java.util.Arrays;

// test class functionalities
/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Point p1 = new Point(1, 2, 3);
        Point p2 = new Point(1, 4, 3);
        Point p3 = new Point(1, 1, 3);
        Point p4 = new Point(1, 2, 4);
        Point p5 = new Point(1, 2, 6);
        Component c1 = new Component(new Point[] {p1, p2, p3}, new int [][] {{1,2},{0,1}}, "c1", "black");
        Component c2 = new Component(new Point[] {p1, p4, p3,p2}, new int [][] {{1,3},{0,1}}, "c2", "black");
        HouseDesign house = new HouseDesign(new Component[] {c1}, "aaa");
        System.out.println(Arrays.deepToString(c2.getEdgePairs()));
        c2.addPoint(new Point[] {p5});
        c2.addEdge(new int[][] {{3,4}});
        System.out.println(c2.getPointList().length);
        System.out.println(Arrays.deepToString(c2.getEdgePairs()));
        System.out.println(house.getComponentList().length);
        house.addComponent(new Component[] {c2});
        System.out.println(house.getComponentList().length);
    }
}
