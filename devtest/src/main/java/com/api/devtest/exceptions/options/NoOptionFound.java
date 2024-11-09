package com.api.devtest.exceptions.options;

public class NoOptionFound extends RuntimeException {
    public NoOptionFound(String message) {
        super("Unable to create the poll. " + message);
    }
}
