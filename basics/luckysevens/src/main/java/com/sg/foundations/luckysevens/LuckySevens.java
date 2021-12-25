package com.sg.foundations.luckysevens;

import java.util.Random;
import java.util.Scanner;

/**
 * Hello world!
 */
public final class LuckySevens {

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Random rng = new Random();
        Scanner userInput = new Scanner(System.in);

        int diceScore, maxAmount;
        int rollsAtMax = 0, totalRolls = 0;
        int winAmount = 4;
        System.out.printf("How many dollars do you have? ");
        int amount = Integer.valueOf(userInput.nextLine());

        maxAmount = amount;

        while (amount > 0) {
            diceScore = rng.nextInt(6) + rng.nextInt(6) + 2;
            totalRolls++;
            if (diceScore == 7) {
                amount += winAmount;
                if (amount > maxAmount) {
                    rollsAtMax = totalRolls;
                    maxAmount = amount;
                }
            } else {
                amount -= 1;
            }

        }
        System.out.printf("You are broke after %d rolls.%n", totalRolls);
        System.out.printf("You should have quit after %d rolls when you had $%d.%n", rollsAtMax, maxAmount);

    }
}
