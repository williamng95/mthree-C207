package com.sg.foundations.scanner;

import java.util.Scanner;

public class HealthyHearts {
    public static void main(String[] args) {
        int age, maxHR;
        Scanner inputReader = new Scanner(System.in);

        System.out.println("I can calculate the healthy heart rate zone for your exercise! ");
        System.out.println("What is your age?");
        age = Integer.parseInt(inputReader.nextLine());

        maxHR = 220 - age;
        // use only ints so that BPM prints out as int.
        // 
        System.out.println(
                "Your target heart rate zone is from " + (maxHR / 2) + " BPM to " + (maxHR * 85 / 100) + " BPM.");
    }
}
