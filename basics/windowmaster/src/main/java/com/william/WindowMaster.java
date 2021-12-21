package com.william;

import java.util.Scanner;

public class WindowMaster {
    public static void main(String[] args) {
        // declare all variables
        float height, width;
        String stringHeight, stringWidth, stringNumWindows;
        float areaOfWindow, cost, perimeterOfWindow;
        int numWindows;

        // on your own
        String stringGlassCost, stringTrimCost;
        float glassCost, trimCost;

        // scanner
        Scanner myScanner = new Scanner(System.in);

        // height
        do {
            try {
                System.out.println("Please enter window height:");
                stringHeight = myScanner.nextLine();
                height = Float.parseFloat(stringHeight);
                // break out of dowhile if parse succeeds
                break;
            } catch (NumberFormatException ex) {
                System.out.println("invalid height");
            }
        } while (true);

        // width
        do {
            try {
                System.out.println("Please enter window width:");
                stringWidth = myScanner.nextLine();
                width = Float.parseFloat(stringWidth);
                // break out of dowhile if parse succeeds
                break;
            } catch (NumberFormatException ex) {
                System.out.println("invalid width");
            }
        } while (true);

        // number of windows
        do {
            try {
                System.out.println("Please enter number of windows:");
                stringNumWindows = myScanner.nextLine();
                numWindows = Integer.parseInt(stringNumWindows);
                // break out of dowhile if parse succeeds
                break;
            } catch (NumberFormatException ex) {
                System.out.println("invalid input");
            }
        } while (true);

        // glass cost
        do {
            try {
                System.out.println("Please enter unit glass cost:");
                stringGlassCost = myScanner.nextLine();
                glassCost = Float.parseFloat(stringGlassCost);
                // break out of dowhile if parse succeeds
                break;
            } catch (NumberFormatException ex) {
                System.out.println("invalid input");
            }
        } while (true);

        // trim cost
        do {
            try {
                System.out.println("Please enter unit trim cost:");
                stringTrimCost = myScanner.nextLine();
                trimCost = Float.parseFloat(stringTrimCost);
                // break out of dowhile if parse succeeds
                break;
            } catch (NumberFormatException ex) {
                System.out.println("invalid input");
            }
        } while (true);

        areaOfWindow = height * width;
        perimeterOfWindow = 2 * (height + width);

        cost = ((glassCost * areaOfWindow) + (trimCost * perimeterOfWindow)) * numWindows;

        // print resutls back
        System.out.println("Window height = " + stringHeight);
        System.out.println("Window width = " + stringWidth);
        System.out.println("Window area = " + areaOfWindow);
        System.out.println("Window perimeter = " + perimeterOfWindow);

        System.out.println("Total Cost = " + cost);

    }
}