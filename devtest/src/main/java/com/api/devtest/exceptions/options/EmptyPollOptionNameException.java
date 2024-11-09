package com.api.devtest.exceptions.options;

public class EmptyPollOptionNameException extends RuntimeException {
    public EmptyPollOptionNameException(String message) {
        super("Unable to create the option. " + message);
    }
}
