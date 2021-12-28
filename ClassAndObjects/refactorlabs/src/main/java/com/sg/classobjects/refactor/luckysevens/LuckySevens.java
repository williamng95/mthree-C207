package com.sg.classobjects.refactor.luckysevens;

import java.util.Random;

/**
 * Hello world!
 */
public final class LuckySevens {

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */

    Random rng = new Random();

    int amount, maxAmount;
    int rollsAtMax = 0, totalRolls = 0;
    final int WIN_AMOUNT = 4;

    public LuckySevens(int amount) {
        this.amount = amount;
        this.maxAmount = amount;
    }

    public void runSimulate() {
        int diceScore;
        while (amount > 0) {
            diceScore = rng.nextInt(6) + rng.nextInt(6) + 2;
            this.totalRolls++;
            if (diceScore == 7) {
                this.amount += WIN_AMOUNT;
                if (this.amount > this.maxAmount) {
                    this.rollsAtMax = this.totalRolls;
                    this.maxAmount = this.amount;
                }
            } else {
                this.amount -= 1;
            }

        }
        this.printSummary(this.totalRolls, this.rollsAtMax, this.maxAmount);

    }

    private void printSummary(int totalRolls, int rollsAtMax, int maxAmount) {
        System.out.printf("You are broke after %d rolls.%n", totalRolls);
        System.out.printf("You should have quit after %d rolls when you had $%d.%n", rollsAtMax, maxAmount);
    }

}
