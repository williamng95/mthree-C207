package com.sg.foundations.flowcontrol.fors;

import java.util.Scanner;

public class ForTimesFor {
    public static void main(String[] args) {
        int correctAnswer, userAnswer;
        int userScore = 0;
        Scanner userInput = new Scanner(System.in);

        System.out.print("Which times table shall I recite? ");
        int timesTable = Integer.valueOf(userInput.nextLine());
        for (int i = 1; i < 16; i++) {
            System.out.print(i + " * " + timesTable + " is: ");
            userAnswer = Integer.valueOf(userInput.nextLine());
            correctAnswer = (i * timesTable);
            if (userAnswer == correctAnswer) {
                System.out.println("Correct!");
                userScore++;
            } else {
                System.out.println("Sorry no, the answer is: " + correctAnswer);
            }
        }
        System.out.println("You got " + userScore + " correct.");
        if ((userScore / 15.0) > 0.9) {
            System.out.println("Well done!! You're really good at this!");
        } else if ((userScore / 15.0) < 0.5) {
            System.out.println(
                    "Awww you didnt get at least half of them correct. Perhaps you should study your times tables more.");
        }
    }
}
