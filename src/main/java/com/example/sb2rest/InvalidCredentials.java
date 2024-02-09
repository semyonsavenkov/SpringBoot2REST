package com.example.sb2rest;

public class InvalidCredentials extends RuntimeException{

    public InvalidCredentials(String msg) {
        super(msg);
    }

}
