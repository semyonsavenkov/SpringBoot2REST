package com.example.sb2rest;

import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorizationController {

    @Autowired
    AuthorizationService service;

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
