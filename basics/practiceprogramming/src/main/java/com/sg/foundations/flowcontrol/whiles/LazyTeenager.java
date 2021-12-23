package com.sg.foundations.flowcontrol.whiles;

import java.util.Random;

public class LazyTeenager {
    public static void main(String[] args) {
        double cleanChance = 0;
        int remindCount = 0;

        Random rng = new Random();

        do {
            System.out.println("Clean your room!! (x" + remindCount + ")");
            remindCount++;
            cleanChance += 0.1;
            if (rng.nextDouble() < cleanChance) {
                System.out.println("FINE! I'LL CLEAN MY ROOM. BUT I REFUSE TO EAT MY PEAS.");
                break;
            }
            if (remindCount > 7) {
                System.out.println(
                        "Clean your room!! That's IT, I'm doing it!!! YOU'RE GROUNDED AND I'M TAKING YOUR XBOX!");
                break;
            }
        } while (true);
    }
}
