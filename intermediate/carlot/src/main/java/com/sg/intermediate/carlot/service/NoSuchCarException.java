package com.sg.intermediate.carlot.service;

public class NoSuchCarException extends Exception {

    /**
     * @param message
     */
    public NoSuchCarException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public NoSuchCarException(String message, Throwable cause) {
        super(message, cause);
    }

}
