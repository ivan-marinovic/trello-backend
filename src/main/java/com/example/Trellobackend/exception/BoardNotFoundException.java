package com.example.Trellobackend.exception;

public class BoardNotFoundException extends RuntimeException{
    public BoardNotFoundException(String msg) {
        super(msg);
    }
}
