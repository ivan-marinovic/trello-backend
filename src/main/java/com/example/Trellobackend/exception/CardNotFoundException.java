package com.example.Trellobackend.exception;

public class CardNotFoundException extends RuntimeException {
    public CardNotFoundException(String msg) {
        super(msg);
    }
}
