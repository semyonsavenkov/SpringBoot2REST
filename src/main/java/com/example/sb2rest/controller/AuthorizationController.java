package com.example.sb2rest.controller;

import com.example.sb2rest.model.Authorities;
import com.example.sb2rest.exceptions.UnauthorizedUser;
import com.example.sb2rest.exceptions.InvalidCredentials;
import com.example.sb2rest.model.service.AuthorizationService;
import com.example.sb2rest.model.User;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorizationController {

    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities(user);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unathorizedHandler(UnauthorizedUser exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.valueOf(401));
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invalidCredsHandler(InvalidCredentials exception){
        LoggerFactory.getLogger(AuthorizationController.class).error(exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.valueOf(400));
    }

}
