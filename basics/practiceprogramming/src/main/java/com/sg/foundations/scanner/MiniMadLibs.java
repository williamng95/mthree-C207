package com.sg.foundations.scanner;

import java.util.Scanner;

public class MiniMadLibs {
    public static void main(String[] args) {
        String nounOne, adjectiveTwo, nounThree, numberFour, adjectiveFive, pluralNounSix, pluralNounSeven,
                pluralNounEight, verbNine, verbTen;
        Scanner inputReader = new Scanner(System.in);

        System.out.println("Let's play MAD LIBS!");

        System.out.print("I need a noun: ");
        nounOne = inputReader.nextLine();

        System.out.print("Now an adjective: ");
        adjectiveTwo = inputReader.nextLine();

        System.out.print("Another noun: ");
        nounThree = inputReader.nextLine();

        System.out.print("And a number: ");
        numberFour = inputReader.nextLine();

        System.out.print("Another adjective: ");
        adjectiveFive = inputReader.nextLine();

        System.out.print("A plural noun: ");
        pluralNounSix = inputReader.nextLine();

        System.out.print("Another one: ");
        pluralNounSeven = inputReader.nextLine();

        System.out.print("One more: ");
        pluralNounEight = inputReader.nextLine();

        System.out.print("A verb (infinitive form): ");
        verbNine = inputReader.nextLine();

        System.out.print("Same verb (past participle): ");
        verbTen = inputReader.nextLine();

        System.out.println("** NOW LETS GET MAD (libs) ***");

        System.out.println(nounOne + ": the " + adjectiveTwo + " frontier. These are the voyages of the starship "
                + nounThree + ". Its " + numberFour + "-year mission: to explore strange " + adjectiveFive + " "
                + pluralNounSix + ", to seek out " + adjectiveFive + " " + pluralNounSeven + " and " + adjectiveFive
                + " " + pluralNounEight + ", to boldly " + verbNine + " where no one has " + verbTen + " before.");
    }

}
