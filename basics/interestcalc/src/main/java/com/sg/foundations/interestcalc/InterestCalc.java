package com.sg.foundations.interestcalc;

import java.util.Scanner;

/**
 * Hello world!
 */
public final class InterestCalc {
    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        // compounding periods is a constant, use an array to store the different
        // possible periods
        final int[] COMPOND_PERIODS = { 1, 4, 12, 365 };
        double balance, interestRate;
        Scanner userInput = new Scanner(System.in);

        System.out.printf("How much do you want to invest? ");
        double startBalance = Double.valueOf(userInput.nextLine());
        System.out.printf("How many years are you investing for? ");
        int numYears = Integer.valueOf(userInput.nextLine());
        System.out.print("What is the annual interest rate %? ");
        double annualInterest = Double.valueOf(userInput.nextLine());
        System.out.println("How often is interest compounded? KEy in the number.");
        System.out.print("(1.annually 2.quarterly 3.monthly 4.daily): ");
        int chosenPeriod = COMPOND_PERIODS[Integer.valueOf(userInput.nextLine()) - 1];

        interestRate = 1 + (annualInterest / (chosenPeriod * 100));
        System.out.println("Calculating...");
        for (int i = 0; i < numYears; i++) {
            // compound interest can be calculated using power
            balance = startBalance * Math.pow(interestRate, chosenPeriod);
            System.out.printf("Year %d:%n", i + 1);
            System.out.printf("Began with $%.2f%n", startBalance);
            // compute interest earned on the fly
            System.out.printf("Earned $%.2f%n", balance - startBalance);
            System.out.printf("Ended with $%.2f%n", balance);
            // set starting balance for next year
            startBalance = balance;
        }

    }
}
