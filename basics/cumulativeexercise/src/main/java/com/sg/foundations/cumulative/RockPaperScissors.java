package com.sg.foundations.cumulative;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Random computer = new Random();
        Scanner userInput = new Scanner(System.in);
        int numRounds, computerMove, userMove, userWin, compWin;
        String[] moves = { "Rock", "Paper", "Scissors" };
        boolean isPlay = true;

        while (isPlay) {
            System.out.println("Lets play Rock, Paper, Scissors!");
            System.out.printf("How many rounds shall we play? (between 1 and 10): ");
            numRounds = Integer.valueOf(userInput.nextLine());
            // reset game tracking metrics
            userWin = 0;
            compWin = 0;
            // input range validation force quit the program by return
            if (numRounds < 1) {
                System.out.println("We must play at least one round of Rock, Paper, Scissors!");
                return;
            } else if (numRounds > 10) {
                System.out.println("Too many rounds!");
                return;
            }
            for (int i = 0; i < numRounds; i++) {
                System.out.printf("Rock, Paper, Scissors Round %d!%n", i + 1);
                computerMove = computer.nextInt(3);
                System.out.printf("Your move (1. Rock 2. Paper 3.Scissors): ");
                userMove = Integer.valueOf(userInput.nextLine()) - 1;
                System.out.printf("I chose %s!%n", moves[computerMove]);
                switch (userMove - computerMove) {
                    case 1:
                    case -2:
                        System.out.println("You Win!");
                        userWin++;
                        break;
                    case -1:
                    case 2:
                        System.out.println("I Win!");
                        compWin++;
                        break;
                    case 0:
                        System.out.println("It's a tie!");
                        break;

                    default:
                        break;
                }
            }

            System.out.println("");
            System.out.println("GAME SUMMARY");
            System.out.printf("Your Wins: %d%n", userWin);
            System.out.printf("My Wins: %d%n", compWin);
            System.out.printf("Ties: %d%n", numRounds - userWin - compWin);

            if (userWin == compWin) {
                System.out.println("Its a tie....");
            } else {
                System.out.printf("%s WIN!%n", userWin > compWin ? "You" : "I");
            }

            System.out.println("");
            System.out.print("Do you want to play again? (y/n) ");
            isPlay = userInput.nextLine().equals("y");
        }
        System.out.println("Thanks for playing!");

    }
}
