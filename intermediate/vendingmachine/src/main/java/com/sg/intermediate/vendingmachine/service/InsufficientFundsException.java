package com.sg.intermediate.vendingmachine.service;

public class InsufficientFundsException extends Exception {

    /**
     * @param message
     */
    public InsufficientFundsException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public InsufficientFundsException(String message, Throwable cause) {
        super(message, cause);
    }

}
