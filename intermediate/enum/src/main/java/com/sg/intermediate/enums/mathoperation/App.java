package com.sg.intermediate.enums.mathoperation;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please provide 2 integers:");

        int op1 = Integer.valueOf(userInput.nextLine());
        int op2 = Integer.parseInt(userInput.nextLine());

        IntMath calculator = new IntMath();

        for (MathOperators operator : MathOperators.values()) {
            System.out.printf("%d %s %d = %d%n", op1, operator.name(), op2, calculator.calculate(operator, op1, op2));
        }
    }
}
