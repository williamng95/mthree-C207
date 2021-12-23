package com.sg.foundations.flowcontrol.random;

import java.util.Random;
import java.util.Scanner;

public class GuessMeMore {
    public static void main(String[] args) {
        Random rng = new Random();
        Scanner inputReader = new Scanner(System.in);
        int userGuess;
        // nextInt(201) produces numbers between 0-200.
        // for -100 to 100, simply deduct 100 from the result.
        int chosenNumber = rng.nextInt(201) - 100;
        System.out.println("I've chosen a number between -100 and 100. Betcha can't guess it!");
        System.out.print("Your guess: ");
        userGuess = Integer.parseInt(inputReader.nextLine());
        System.out.print(userGuess + "? ");
        if (userGuess == chosenNumber) {
            System.out.println("Wow nice guess! That was it!");
        } else {
            if (userGuess < chosenNumber) {
                System.out.print("Ha, nice try - too low! ");
            }
            if (userGuess > chosenNumber) {
                System.out.print("Too bad, way too high. ");
            }
            System.out.println("I chose " + chosenNumber);
        }

    }
}
