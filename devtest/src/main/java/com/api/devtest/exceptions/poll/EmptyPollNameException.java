package com.api.devtest.exceptions.poll;

public class EmptyPollNameException extends RuntimeException {
    public EmptyPollNameException(String message) {
        super(message);
    }
}
