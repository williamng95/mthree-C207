package com.sg.foundations.flowcontrol.ifs;

import java.util.Random;
import java.util.Scanner;

public class GuessMe {
    public static void main(String[] args) {
        Random rng = new Random();
        Scanner inputReader = new Scanner(System.in);
        int userGuess;
        int chosenNumber = rng.nextInt(100) + 1;
        System.out.println("I've chosen a number. Betcha can't guess it!");
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
