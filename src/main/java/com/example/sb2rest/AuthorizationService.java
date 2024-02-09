package com.example.sb2rest;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AuthorizationService {

    @Autowired
    UserRepository userRepository;

    UserArgumentResolver resolver;

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
