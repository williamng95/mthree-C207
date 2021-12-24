package com.sg.foundations.factorizer;

import java.util.Scanner;

/**
 * Hello world!
 */
public final class Factorizer {

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int numFactors = 0, sumFactors = 0;
        System.out.print("What number would you like to factor? ");
        int number = Integer.valueOf(userInput.nextLine());
        System.out.println("The factors of " + number + " are:");

        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                System.out.print(i + " ");
                numFactors++;
                sumFactors += i;

            }
        }
        System.out.println("");
        // use string formatting and ternary operators for conciseness
        System.out.printf("%d has %d factor%s.%n", number, numFactors, numFactors == 1 ? "" : "s");
        System.out.printf("%d is %sa perfect number.%n", number, sumFactors == number ? "" : "not ");
        System.out.printf("%d is %sa prime number.%n", number, numFactors == 1 ? "" : "not ");

    }
}
