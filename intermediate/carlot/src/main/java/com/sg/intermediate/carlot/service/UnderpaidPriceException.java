package com.sg.intermediate.carlot.service;

public class UnderpaidPriceException extends Exception {

    /**
     * @param message
     */
    public UnderpaidPriceException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public UnderpaidPriceException(String message, Throwable cause) {
        super(message, cause);
    }

}
