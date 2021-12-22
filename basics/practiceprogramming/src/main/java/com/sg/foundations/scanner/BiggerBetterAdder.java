package com.sg.foundations.scanner;

import java.util.Scanner;

public class BiggerBetterAdder {
    public static void main(String[] args) {
        double numberOne, numberTwo, numberThree;
        Scanner inputReader = new Scanner(System.in);
        System.out.println("Key in three numbers for me to add!");
        System.out.println("First Number:");
        numberOne = Double.parseDouble(inputReader.nextLine());
        System.out.println("Second Number:");
        numberTwo = Double.parseDouble(inputReader.nextLine());
        System.out.println("Third Number:");
        numberThree = Double.parseDouble(inputReader.nextLine());
        System.out.println("Your Result:");
        System.out.println(
                numberOne + " + " + numberTwo + " + " + numberThree + " = " + (numberOne + numberTwo + numberThree));
    }
}
