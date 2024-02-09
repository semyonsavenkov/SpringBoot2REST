package com.example.sb2rest.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class User {

    @NotBlank
    @Size(min = 6, max = 20)
    private final String name;

    @NotBlank
    @Size(min = 8, max = 12)
    private final String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

}
