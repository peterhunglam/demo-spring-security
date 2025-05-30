package com.gpa.demo_spring_security.controller;

import com.gpa.demo_spring_security.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    public User signUp(@RequestBody User user) {
        return user;
    }
}
