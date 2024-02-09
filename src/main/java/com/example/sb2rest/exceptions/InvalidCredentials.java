package com.example.sb2rest.exceptions;

public class InvalidCredentials extends RuntimeException{

    public InvalidCredentials(String msg) {
        super(msg);
    }

}
