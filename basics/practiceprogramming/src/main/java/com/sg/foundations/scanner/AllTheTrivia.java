package com.sg.foundations.scanner;

import java.util.Scanner;

public class AllTheTrivia {
    public static void main(String[] args) {
        String answerOne, answerTwo, answerThree, answerFour;
        Scanner inputreader = new Scanner(System.in);

        System.out.print("Which planet rotates on its side? ");
        answerOne = inputreader.nextLine();
        System.out.print("Which is the largest planet in the Solar System? ");
        answerTwo = inputreader.nextLine();
        System.out.print("Which test checks if a computer can pass as a human? ");
        answerThree = inputreader.nextLine();
        System.out.print("What is the same as 8 bits? ");
        answerFour = inputreader.nextLine();

        System.out.println("Wow! 8 bits is a " + answerOne);
        System.out.println("Really? " + answerThree + " is the largest planet in the Solar System?");
        System.out.println("It's amazing that " + answerTwo + " can rotate on its side.");
        System.out.println("So a computer only needs to pass the " + answerFour + " test to pass off as human. Sweet!");
    }
}
