package com.example.sb2rest.repository;

import com.example.sb2rest.model.Authorities;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

        public List<Authorities> getUserAuthorities(String name, String password) {
            if(name.equals("admin") && password.equals("admin"))return List.of(Authorities.values());

            if (name.equals("user") && password.equals("pass")) return List.of(Authorities.READ);

            if (name.equals("author") && password.equals("authorpass"))
                return List.of(Authorities.READ, Authorities.WRITE);

            return new ArrayList<>();
        }
}

