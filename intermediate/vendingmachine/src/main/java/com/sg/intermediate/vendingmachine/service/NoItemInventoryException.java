package com.sg.intermediate.vendingmachine.service;

public class NoItemInventoryException extends Exception {

    /**
     * @param message
     */
    public NoItemInventoryException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public NoItemInventoryException(String message, Throwable cause) {
        super(message, cause);
    }

}
