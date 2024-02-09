package com.example.sb2rest.model.service;

import com.example.sb2rest.exceptions.InvalidCredentials;
import com.example.sb2rest.exceptions.UnauthorizedUser;
import com.example.sb2rest.model.Authorities;
import com.example.sb2rest.model.User;
import com.example.sb2rest.model.UserArgumentResolver;
import com.example.sb2rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AuthorizationService {

    private final UserRepository userRepository;

    public AuthorizationService() {
        userRepository = new UserRepository();
    }

    public List<Authorities> getAuthorities(String name, String password) {
        if (isEmpty(name) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(name, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + name);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }

    public List<Authorities> getAuthorities(User user) {
        return getAuthorities(user.getName(), user.getPassword());
    }
}
