package com.example.les11.controller;

import com.example.les11.model.Student;
import com.example.les11.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository repos;

    @GetMapping
    public ResponseEntity<Iterable<Student>> getStudents() {
        return ResponseEntity.ok(repos.findAll());
    }

    @GetMapping("/fullname")
    public ResponseEntity<Iterable<Student>> getStudentsByName(@RequestParam String query) {
        return ResponseEntity.ok(repos.findByFullNameContainingIgnoreCaseOrderByFullName(query));
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student s) {
        repos.save(s);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + s.getStudentNr()).toUriString());
        return ResponseEntity.created(uri).body(s);
    }
}
