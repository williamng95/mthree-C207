package com.sg.foundations.flowcontrol.fors;

import java.util.Scanner;

public class ForTimes {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Which times table shall I recite? ");
        int timesTable = Integer.valueOf(userInput.nextLine());
        for (int i = 1; i < 16; i++) {
            System.out.println(i + " * " + timesTable + " is: " + (i * timesTable));
        }
    }
}
