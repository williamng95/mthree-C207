package com.sg.foundations.flowcontrol.random;

import java.util.Random;
import java.util.Scanner;

public class HighRoller {
    public static void main(String[] args) {
        Random diceRoller = new Random();
        Scanner userInput = new Scanner(System.in);

        System.out.println("How many sides are there on the dice?");
        int dieSides = Integer.valueOf(userInput.nextLine());
        int rollResult = diceRoller.nextInt(dieSides) + 1;

        System.out.println("TIME TO ROOOOOOLL THE DICE!");
        System.out.println("I rolled a " + rollResult);

        if (rollResult == 1) {
            System.out.println("You rolled a critical failure! Ouch.");
        } else if (rollResult == (dieSides + 1)) {
            System.out.println("You rolled a critical! Nice job!");
        }
    }
}
