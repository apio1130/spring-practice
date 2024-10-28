package com.demo.sample.retry;

public class IgnoreException extends RuntimeException {

    public IgnoreException(String message) {
        super(message);
    }
}