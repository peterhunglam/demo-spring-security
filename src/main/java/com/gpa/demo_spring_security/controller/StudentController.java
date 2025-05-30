package com.gpa.demo_spring_security.controller;

import com.gpa.demo_spring_security.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Brian", 80),
            new Student(2, "Bi", 90)
    ));

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return students;
    }

    @GetMapping("token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("students")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }
}
