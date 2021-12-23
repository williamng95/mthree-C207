package com.sg.foundations.flowcontrol.whiles;

import java.util.Random;

public class MaybeItLovesMe {
    public static void main(String[] args) {
        Random rng = new Random();
        System.out.println("Well here goes nothing...");
        int numPetals = rng.nextInt(77) + 13;

        boolean itLoves;
        do {
            if (numPetals % 2 == 0) {
                System.out.println("It loves me NOT!");
                itLoves = false;
            } else {
                System.out.println("It loves me!");
                itLoves = true;
            }
            numPetals--;
        } while (numPetals > 0);
        if (itLoves) {
            System.out.println("Oh, wow! It really LOVES me!");
        } else {
            System.out.println("Awwww, bummer.");
        }
    }
}
