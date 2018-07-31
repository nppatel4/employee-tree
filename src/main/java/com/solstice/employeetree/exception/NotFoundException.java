package com.solstice.employeetree.exception;

public class NotFoundException extends Exception {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable t) {
        super(message, t);
    }

}
