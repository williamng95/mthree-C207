package com.sg.intermediate.carlot.service;

public class OverpaidPriceException extends Exception {

    /**
     * @param message
     */
    public OverpaidPriceException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public OverpaidPriceException(String message, Throwable cause) {
        super(message, cause);
    }

}
