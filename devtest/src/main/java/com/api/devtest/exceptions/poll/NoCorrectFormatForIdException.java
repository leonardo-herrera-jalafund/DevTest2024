package com.api.devtest.exceptions.poll;

public class NoCorrectFormatForIdException extends RuntimeException {
    public NoCorrectFormatForIdException(String message) {
        super("Unable to create the poll. " + message);
    }
}
