package com.sg.classobject.calculator;

import java.util.Scanner;

/**
 * Hello world!
 */
public final class App {
    private String[] menuOptions = { "Add", "Subtract", "Mulitply", "Divide", "Exit" };
    private String[] operatorSign = { "+", "-", "x", "÷" };
    Scanner userInput = new Scanner(System.in);

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public void main() {
        this.appLoop();
        System.out.println("Thanks for using the Calculator App!");
        System.out.println("See you soon!");
    }

    private int printMenu() {
        int userChoice;
        System.out.println("");
        System.out.println("Please enter one of the following options: (number only)");
        for (int i = 0; i < menuOptions.length; i++) {
            System.out.printf("%d. %s%n", i + 1, menuOptions[i]);
        }
        while (true) {
            System.out.print("Your Input: ");

            try {
                userChoice = Integer.valueOf(this.userInput.nextLine());
            } catch (Exception e) {
                System.out.println("Error");
                continue;
            }

            if ((userChoice < 6) && (userChoice > 0)) {
                return userChoice;
            }

        }

    }

    private void computeResult(int choice) {
        double result = 0;
        System.out.println("Please provide 2 numbers: ");
        System.out.printf("First Number: ");
        double firstNum = Double.valueOf(this.userInput.nextLine());
        System.out.printf("Second Number: ");
        double secondNum = Double.valueOf(this.userInput.nextLine());
        System.out.printf("You chose to %s %f and %f.%n", this.menuOptions[choice].toLowerCase(), firstNum, secondNum);
        System.out.printf("%f %s %f = ", firstNum, this.operatorSign[choice], secondNum);

        switch (choice) {
            case 0:
                result = SimpleCalculator.add(firstNum, secondNum);

                break;
            case 1:
                result = SimpleCalculator.subtract(firstNum, secondNum);
                break;
            case 2:
                result = SimpleCalculator.multiply(firstNum, secondNum);
                break;
            case 3:
                result = SimpleCalculator.divide(firstNum, secondNum);
                break;

        }
        System.out.printf("%f%n", result);

    }

    private void appLoop() {
        System.out.println("Welcome to my Simple Calculator App.");
        while (true) {
            int userChoice = printMenu();
            if (userChoice == 5) {
                return;
            }
            computeResult(userChoice - 1);
        }

    }

}
