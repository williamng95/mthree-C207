package com.sg.foundations.flowcontrol.whiles;

import java.util.Scanner;

public class StayPositive {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int count = 0;
        // use a while loop to keep requesting for positive input
        while (count <= 0) {
            System.out.println("Where shall we start counting down from?");
            count = Integer.valueOf(userInput.nextLine());
            if (count <= 0) {
                System.out.println("Please enter a posiitve integer for me to count down!");
            }
        }

        System.out.println("");
        System.out.println("Counting down...");
        System.out.println("");

        int lineCount = 0;
        while (count >= 0) {
            System.out.print(count + " ");
            count--;
            lineCount++;
            if (lineCount == 10) {
                // print a newline and reset when there are 10 numbers in the current line.
                System.out.println("");
                lineCount = 0;
            }
        }
        System.out.println("");
        System.out.println("Blast off!");

    }
}
