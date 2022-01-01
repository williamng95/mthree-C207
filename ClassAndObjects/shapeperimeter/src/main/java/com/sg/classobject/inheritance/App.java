package com.sg.classobject.inheritance;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Shape rect1 = new Rectangle(10,20);
        System.out.println(rect1.getArea());
        System.out.println(rect1.getPerimeter());
    }
}
