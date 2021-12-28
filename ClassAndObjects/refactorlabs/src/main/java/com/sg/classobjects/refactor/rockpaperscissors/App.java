package com.sg.classobjects.refactor.rockpaperscissors;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        RockPaperScissors game = new RockPaperScissors();
        Scanner userInput = new Scanner(System.in);
        while (game.isPlay){
            System.out.println("Lets play Rock, Paper, Scissors!");
            System.out.printf("How many rounds shall we play? (between 1 and 10): ");
            if (game.setNumRounds(Integer.valueOf(userInput.nextLine()))){
                game.playGame();
                game.replay();
            };  
        } 

        
        System.out.println("Thanks for playing!");
        
    }
}
