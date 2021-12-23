package com.sg.foundations.flowcontrol.whiles;

import java.util.Random;
import java.util.Scanner;

public class BewareTheKraken {
    public static void main(String[] args) {
        System.out.println("Already, get those flippers and wet suit on - we're going diving!");
        System.out.println("Here we goooOOooOooo.....! *SPLASH*");
        Scanner userInput = new Scanner(System.in);
        Random randomGen = new Random();
        int randomFish;
        int depthDivedInFt = 0;
        // Turns out the ocean is only so deep, 36200 at the deepest survey,
        // so if we reach the bottom ... we should probably stop.

        while (depthDivedInFt < 36200) {
            System.out.println("So far, we've swum " + depthDivedInFt + " feet");
            System.out.println("Do you want to stop? (y/n) ");
            if (userInput.nextLine().equals("y")) {
                break;
            } else {
                System.out.println("Alright, lets continue!");
            }
            if (depthDivedInFt >= 20000) {
                randomFish = randomGen.nextInt(3);
                if (randomFish == 0) {
                    System.out.println("Uhhh, I think I see a Kraken, guys ....");
                    System.out.println("TIME TO GO!");
                    break;
                } else if (randomFish == 1) {
                    System.out.println("Oh look some tuna");
                } else {
                    System.out.println("Those sea horses look so carefree");
                }

            }
            // i can swim really fast! 1000ft at a time!
            depthDivedInFt += 1000;
        }
        System.out.println("");
        System.out.println("We ended up swimiming " + depthDivedInFt + " feet down");
        System.out.println("I bet we can do better next time!");
    }
}
// if the while loop condition is changed to just read true, the ocean has no
// maximum depth to depth to.
