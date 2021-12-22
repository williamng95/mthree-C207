package com.sg.foundations.flowcontrol.ifs;

import java.util.Scanner;

public class TriviaNight {
    public static void main(String[] args) {
        int totalScore = 0;
        int answerGiven;

        final String ANSWER_PROMPT = "YOUR ANSWER: 4";
        final String CORRECT_PROMPT = "CORRECTT!!";
        final String WRONG_PROMPT = "WRONG!";

        Scanner inputReader = new Scanner(System.in);

        System.out.println("It's TRIVIA NIGHT! Are you ready?!");
        System.out.println("");
        System.out.println("FIRST QUESTION!");
        System.out.println("");
        System.out.println("What is the Lowest Level Programming Language?");
        System.out.println("1. Source Code");
        System.out.println("2. Assembly Language");
        System.out.println("3. C#");
        System.out.println("4. Machine code");
        System.out.print(ANSWER_PROMPT);
        answerGiven = Integer.valueOf(inputReader.nextLine());

        if (answerGiven == 4) {
            System.out.println(CORRECT_PROMPT);
            totalScore += 1;
        } else {
            System.out.println(WRONG_PROMPT);
        }
        System.out.println("Your current score: " + totalScore);
        System.out.println("There are 2 questions remaining.");

        System.out.println("SECOND QUESTION.");
        System.out.println("");
        System.out.println("Website Security CAPTCHA Forms Are Descended From the Work of?");
        System.out.println("1. Grace Hopper");
        System.out.println("2. Alan Turing");
        System.out.println("3. Charles Babbage");
        System.out.println("4. Larry Page");
        System.out.print(ANSWER_PROMPT);
        answerGiven = Integer.valueOf(inputReader.nextLine());
        if (answerGiven == 2) {
            System.out.println(CORRECT_PROMPT);
            totalScore += 1;
        } else {
            System.out.println(WRONG_PROMPT);
        }
        System.out.println("Your current score: " + totalScore);
        System.out.println("There is 1 question remaining.");

        System.out.println("THIRD QUESTION!!");
        System.out.println("");
        System.out.println("Which of These Sci-Fi Ships Was Once Slated for a Full-Size Replica in Las Vegas?");
        System.out.println("1. Serenity");
        System.out.println("2. The Battlestar Galactica");
        System.out.println("3. The USS Enterprise");
        System.out.println("4. The Millennium Falcon");
        System.out.print(ANSWER_PROMPT);
        answerGiven = Integer.valueOf(inputReader.nextLine());
        if (answerGiven == 3) {
            System.out.println(CORRECT_PROMPT);
            totalScore += 1;
        } else {
            System.out.println(WRONG_PROMPT);
        }

        if (totalScore > 0) {
            System.out.println("Nice job! You got " + totalScore + " / 3 questions correct!");
        } else {
            System.out.println("Aww you didn't get any correct. Better luck next time!");
        }

    }
}
