package com.sg.classobjects.refactor.factorizer;

import java.util.Scanner;

/**
 * Hello world!
 */
public class Factorizer {

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    Scanner userInput = new Scanner(System.in);
    private int numFactors, sumFactors, number;

    public Factorizer() {
        this.numFactors = 0;
        this.sumFactors = 0;
        System.out.print("What number would you like to factor? ");
        this.number = Integer.valueOf(userInput.nextLine());
    }

    public void factorize() {
        System.out.println("The factors of " + this.number + " are:");

        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                System.out.print(i + " ");
                this.numFactors++;
                this.sumFactors += i;

            }
        }
        System.out.println("");
        // use string formatting and ternary operators for conciseness
        System.out.printf("%d has %d factor%s.%n", this.number, this.numFactors, this.numFactors == 1 ? "" : "s");
        System.out.printf("%d is %sa perfect number.%n", this.number, this.sumFactors == this.number ? "" : "not ");
        System.out.printf("%d is %sa prime number.%n", this.number, this.numFactors == 1 ? "" : "not ");
    }

}
