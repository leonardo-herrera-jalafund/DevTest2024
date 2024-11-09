package com.api.devtest.exceptions.poll;

public class BadFormatPollNameException extends RuntimeException {
    public BadFormatPollNameException(String message) {
        super("Unable to create the poll. " + message);
    }
}
