package com.gpa.demo_spring_security.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String index(HttpServletRequest request) {
        return "test, session ID: " + request.getSession().getId();
    }
}
