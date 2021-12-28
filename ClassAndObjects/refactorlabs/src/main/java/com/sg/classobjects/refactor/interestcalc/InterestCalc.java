package com.sg.classobjects.refactor.interestcalc;

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

    // compounding periods is a constant, use an array to store the different
    // possible periods
    private final int[] COMPOND_PERIODS = { 1, 4, 12, 365 };
    private double startBalance, annualInterest;
    private int chosenPeriod, numYears;
    Scanner userInput = new Scanner(System.in);

    public InterestCalc() {
        System.out.printf("How much do you want to invest? ");
        this.startBalance = Double.valueOf(userInput.nextLine());
        System.out.printf("How many years are you investing for? ");
        this.numYears = Integer.valueOf(userInput.nextLine());
        System.out.print("What is the annual interest rate %? ");
        this.annualInterest = Double.valueOf(userInput.nextLine());
        System.out.println("How often is interest compounded? Key in the number.");
        System.out.print("(1.annually 2.quarterly 3.monthly 4.daily): ");
        this.chosenPeriod = COMPOND_PERIODS[Integer.valueOf(userInput.nextLine()) - 1];
    }

    public void calculateInterest() {
        double balance;
        double interestRate = 1 + (annualInterest / (chosenPeriod * 100));
        System.out.println("Calculating...");
        for (int i = 0; i < this.numYears; i++) {
            // compound interest can be calculated using power
            balance = this.startBalance * Math.pow(interestRate, this.chosenPeriod);
            this.yearSummary(this.startBalance, balance, i + 1);
            // set starting balance for next year
            this.startBalance = balance;

        }

    }

    private void yearSummary(double startBalance, double balance, int year) {
        System.out.printf("Year %d:%n", year);
        System.out.printf("Began with $%.2f%n", startBalance);
        // compute interest earned on the fly
        System.out.printf("Earned $%.2f%n", balance - startBalance);
        System.out.printf("Ended with $%.2f%n", balance);
    }
}
