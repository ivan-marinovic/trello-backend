package com.example.Trellobackend.exception;

public class TListNotFoundException extends RuntimeException{
    public TListNotFoundException(String msg) {
        super(msg);
    }
}
