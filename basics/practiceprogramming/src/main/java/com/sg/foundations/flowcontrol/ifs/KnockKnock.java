package com.sg.foundations.flowcontrol.ifs;

import java.util.Scanner;

public class KnockKnock {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        System.out.print("Knock Knock! Guess Who!! ");
        String nameGuess = inputReader.nextLine();
        // strings need to use .equals() for comparison.
        // simply using == compares objects, as Strings are stored as objects in Java.
        // Hence, the == can give unpredictable results (in this case does not alwasy
        // succeed)

        // we can also use equalsIgnoreCase() to ignore the capitalization of the input.
        if (nameGuess.equalsIgnoreCase("Marty McFly")) {
            System.out.println("Hey! That's right! I'm back!");
            System.out.println("... from the Future.");
        } else {
            System.out.println("Dude, do I -look- like " + nameGuess);
        }
    }
}
