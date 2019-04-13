package com.qkforex.dev.concurrency.chapter08;

public class RunnableDenyException extends RuntimeException {
    public RunnableDenyException(String message) {
        super(message);
    }
}
