package com.example.sb2rest;

public class UnauthorizedUser extends RuntimeException {

    public UnauthorizedUser(String msg) {
        super(msg);
    }

}
