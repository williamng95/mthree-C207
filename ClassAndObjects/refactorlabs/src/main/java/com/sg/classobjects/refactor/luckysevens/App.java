package com.sg.classobjects.refactor.luckysevens;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in);
        System.out.printf("How many dollars do you have? ");
        
        LuckySevens rollSimulator = new LuckySevens(Integer.valueOf(userInput.nextLine())) ;
        rollSimulator.runSimulate();
    }
}
