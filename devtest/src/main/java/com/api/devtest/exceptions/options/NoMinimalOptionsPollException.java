package com.api.devtest.exceptions.options;

public class NoMinimalOptionsPollException extends RuntimeException {
    public NoMinimalOptionsPollException(String message) {
        super("Unable to create the poll. " + message);
    }
}
