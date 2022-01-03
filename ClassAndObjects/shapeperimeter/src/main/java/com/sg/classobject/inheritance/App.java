package com.sg.classobject.inheritance;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Ellipse ellipse1 = new Circle(2);
        System.out.println(ellipse1.getArea());
        System.out.println(ellipse1.getPerimeter());
        System.out.println(ellipse1.getMinorRadius());

        // demo polymorphism where child method overrides parent
        System.out.println("Rectangle:");
        Polygon rectangle1 = new Rectangle(2, 1);
        rectangle1.getArea();

        // show overload works
        System.out.println("Equilateral triangle:");
        Shape equi = new Triangle(1);
        System.out.println(equi.getArea());
        System.out.println(equi.getPerimeter());

        System.out.println("Triangle:");
        Triangle triangle1 = new Triangle(new double[] { 1, 2, 2 });
        System.out.println(triangle1.getArea());
        System.out.println(triangle1.getPerimeter());
    }
}
