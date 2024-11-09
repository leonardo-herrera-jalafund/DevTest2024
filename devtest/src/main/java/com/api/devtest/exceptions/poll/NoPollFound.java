package com.api.devtest.exceptions.poll;

public class NoPollFound extends RuntimeException {
    public NoPollFound(String message) {
        super("Unable to create the poll. " + message);
    }
}
