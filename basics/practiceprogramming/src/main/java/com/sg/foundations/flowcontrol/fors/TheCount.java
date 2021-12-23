package com.sg.foundations.flowcontrol.fors;

import java.util.Scanner;

public class TheCount {
    public static void main(String[] args) {
        System.out.println("*** I LOVE TO COUNT! LET ME SHARE MY COUNTING WITH YOU! ***");
        Scanner userInput = new Scanner(System.in);
        int startAt, stopAt, stepSize;
        int lineCount = 0;
        System.out.print("Start at: ");
        startAt = Integer.valueOf(userInput.nextLine());
        System.out.print("Stop at: ");
        stopAt = Integer.valueOf(userInput.nextLine());
        System.out.print("Count by: ");
        stepSize = Integer.valueOf(userInput.nextLine());

        for (int i = startAt; i <= stopAt; i += stepSize) {
            System.out.print(i + " ");
            lineCount++;
            if (lineCount == 3) {
                System.out.println("- Ah ah ah!");
                lineCount = 0;
            }
        }
    }
}
