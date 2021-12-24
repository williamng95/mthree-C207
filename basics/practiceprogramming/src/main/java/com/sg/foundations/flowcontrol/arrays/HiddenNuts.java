package com.sg.foundations.flowcontrol.arrays;

import java.util.Random;

public class HiddenNuts {
    public static void main(String[] args) {

        String[] hidingSpots = new String[100];
        Random squirrel = new Random();
        hidingSpots[squirrel.nextInt(hidingSpots.length)] = "Nut";
        System.out.println("The nut has been hidden ...");
        // array default value is null, just check for null object
        for (int i = 0; i < hidingSpots.length; i++) {
            if (hidingSpots[i] != null) {
                System.out.println("Found it! It's in spot# " + i);
            }
        }
    }
}
