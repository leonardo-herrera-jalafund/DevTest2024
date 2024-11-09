package com.api.devtest.exceptions.poll;

public class ElementAlreadyExistException extends RuntimeException {
    public ElementAlreadyExistException(String message) {
        super("Unable to create the poll. " + message);
    }
}
