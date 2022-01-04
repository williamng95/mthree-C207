package com.sg.foundations.classobject.collectionmap.userio;

public class CalculatorApp {
    // refactored without input validation
    private String[] menuOptions = { "Add", "Subtract", "Mulitply", "Divide", "Exit" };
    private String[] operatorSign = { "+", "-", "x", "÷" };
    UserInterface userInput = new UserInterface();

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public void main() {
        this.appLoop();
        userInput.print("Thanks for using the Calculator App!");
        userInput.print("See you soon!");
    }

    private int printMenu() {

        userInput.print("Please enter one of the following options: (number only)");
        for (int i = 0; i < menuOptions.length; i++) {
            userInput.print(String.format("%d. %s%n", i + 1, menuOptions[i]));
        }
        return userInput.readInt("Your Input: ", 1, this.menuOptions.length);

    }

    private void computeResult(int choice) {
        double result = 0;
        System.out.println("Please provide 2 numbers: ");
        double firstNum = userInput.readDouble("First Number: ");
        double secondNum = userInput.readDouble("Second Number: ");
        ;
        userInput.print(String.format("You chose to %s %f and %f.%n", this.menuOptions[choice].toLowerCase(), firstNum,
                secondNum));
        userInput.print(String.format("%f %s %f = ", firstNum, this.operatorSign[choice], secondNum));

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
        userInput.print(String.format("%f%n", result));

    }

    private void appLoop() {
        userInput.print("Welcome to my Simple Calculator App.");
        while (true) {
            int userChoice = printMenu();
            if (userChoice == 5) {
                return;
            }
            computeResult(userChoice - 1);
        }

    }
}
