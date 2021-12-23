package com.sg.foundations.flowcontrol.whiles;

public class LovesMe {
    public static void main(String[] args) {
        System.out.println("Well here goes nothing...");
        int numPetals = 34;
        while (numPetals > 0) {
            if (numPetals % 2 == 0) {
                System.out.println("It loves me NOT!");
            } else {
                System.out.println("It loves me!");
            }
            numPetals--;
        } // use a while instead of do-while, since start condition is already true
    }
}
