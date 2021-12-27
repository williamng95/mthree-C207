package com.sg.foundations.cumulative;

import java.util.Scanner;

public class HealthyHearts {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.printf("What is your age? ");
        int maxHR = 220 - Integer.valueOf(userInput.nextLine());

        System.out.printf("Your maximum heart rate should be %d beats per minute.%n", maxHR);
        // use Math.round to coerce int
        System.out.printf("Your target HR zone is %d - %d beats per minute.%n", Math.round(maxHR * 0.5),
                Math.round(maxHR * 0.85));

    }
}
