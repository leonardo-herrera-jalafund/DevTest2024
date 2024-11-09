package com.api.devtest.exceptions.options;

public class OptionAlreadyExistException extends RuntimeException {
    public OptionAlreadyExistException(String message) {
        super("Unable to create the option. " + message);
    }
}
