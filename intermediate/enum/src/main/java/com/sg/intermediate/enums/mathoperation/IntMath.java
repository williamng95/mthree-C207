package com.sg.intermediate.enums.mathoperation;

public class IntMath {
    public int calculate(MathOperators operator, int operand1, int operand2) {
        switch (operator) {
            case PLUS:
                return operand1 + operand2;
            case MINUS:
                return operand1 - operand2;
            case DIVIDE:
                return operand1 / operand2;
            case MULTIPLY:
                return operand1 * operand2;

            default:
                throw new UnsupportedOperationException();
        }
    }
}
