package com.sg.foundations.flowcontrol.ifs;

import java.util.Scanner;

public class YourLifeInMovies {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        // constants declarations
        final String UP = "Did you know that Pixar's 'Up' came out over a decade ago?";
        final String HARRY_POTTER = "And that the first Harry Potter came out over 15 years ago?";
        final String SPACE_JAM = "Also, Space Jam came out not last decade, but the one before THAT.";
        final String JURASSIC_PARK = "To add on, the original Jurassic Park release is closer to the first lunar landing than it is to today";
        final String MASH_TV = "Whats more, the MASH TV series has been around for almost half a century!";

        String userName;
        int birthYear;

        System.out.print("Hey let's play a game! What's your name? ");
        userName = inputReader.nextLine();
        System.out.print("Ok, " + userName + ", when were you born? ");
        birthYear = Integer.parseInt(inputReader.nextLine());

        if (birthYear >= 2005) {
            System.out.println("I have no fun facts for you, " + userName + ".");
        } else {
            System.out.println("Well " + userName + "...");
            System.out.println(UP);
            if (birthYear < 1995) {
                System.out.println(HARRY_POTTER);
            }
            if (birthYear < 1985) {
                System.out.println(SPACE_JAM);
            }
            if (birthYear < 1975) {
                System.out.println(JURASSIC_PARK);
            }
            if (birthYear < 1965) {
                System.out.println(MASH_TV);
            }
        }

    }
}
