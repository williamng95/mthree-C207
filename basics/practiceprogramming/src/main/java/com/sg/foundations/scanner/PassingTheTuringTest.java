package com.sg.foundations.scanner;

import java.util.Scanner;

public class PassingTheTuringTest {
    public static void main(String[] args) {
        String name, color, food;
        int number;

        Scanner inputReader = new Scanner(System.in);

        System.out.println("Hello there!");
        System.out.print("What's your name? ");
        name = inputReader.nextLine();
        System.out.println("Hi, " + name + "! I'm Alice.");
        System.out.print("What's your favorite color?");
        color = inputReader.nextLine();
        if (color.equals("Lime")) {
            System.out.println("Really? Me too!");
        } else {
            System.out.println("Huh, " + color + "? Mines Lime.");
        }
        System.out.println("I really love limes, they're my favorite food, too.");
        System.out.print("What's YOUR favorite food, " + name + "? ");
        food = inputReader.nextLine();
        System.out.println("WOW! " + food + "? Sounds delicious!");

        System.out.print("Speaking of favorites, whats your favorite number? ");
        number = Integer.parseInt(inputReader.nextLine());
        if (number == 23) {
            System.out.println("Really? That's my favorite number too!");
        } else {
            System.out.println(number + " is a cool number. Mine's 23.");
            System.out.println("Did you know " + number + " * 23 is " + (number * 23) + "? That's a great number too!");
        }
        System.out.println("Well, thanks for talking to me, " + name + "!");

    }
}
