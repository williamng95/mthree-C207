package com.sg.foundations.flowcontrol.fors;

public class DifferentKettleOfFish {
    public static void main(String[] args) {
        int fish = 1;
        for (int i = fish; i < 10; i++) {
            if (i == 3) {
                System.out.println("RED fish!");
            } else if (i == 4) {
                System.out.println("BLUE fish!");
            } else {
                System.out.println(i + " fish!");
            }
        } // need to use i as the checked variable, since fish is no longer being
          // incremented.
    }
}
