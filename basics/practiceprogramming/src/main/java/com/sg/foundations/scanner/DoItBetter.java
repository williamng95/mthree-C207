package com.sg.foundations.scanner;

import java.util.Scanner;

public class DoItBetter {
    public static void main(String[] args) {
        int numMiles, numHotDogs, numLanguage;
        Scanner inputReader = new Scanner(System.in);

        System.out.println("How many miles can you run? ");
        numMiles = Integer.parseInt(inputReader.nextLine());
        System.out.println("Pfft so few? I can run " + (numMiles * 2 + 1) + " miles!");

        System.out.println("How many hot dogs can you eat? ");
        numHotDogs = Integer.parseInt(inputReader.nextLine());
        System.out.println("Mehh... I can eat " + (numHotDogs * 2 + 1) + " hot dogs!");

        System.out.println("How many languages do you know? ");
        numLanguage = Integer.parseInt(inputReader.nextLine());
        System.out.println("Only " + numLanguage + "? I know " + (numLanguage * 2 + 1) + " languages!");

        System.out.println();
    }
}
