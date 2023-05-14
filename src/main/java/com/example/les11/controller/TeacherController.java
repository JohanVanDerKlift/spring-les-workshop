package com.example.les11.controller;

import com.example.les11.dto.TeacherDto;
import com.example.les11.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService service;

    public TeacherController(TeacherService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Iterable<TeacherDto>> getTeachers() {
        return ResponseEntity.ok(service.getTeachers());
    }

    @PostMapping
    public ResponseEntity<Object> createTeacher(@Valid @RequestBody TeacherDto teacherDto, BindingResult br) {
        if (br.hasFieldErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getField() + ": ");
                sb.append(fe.getDefaultMessage());
                sb.append("\n");
            }
            return ResponseEntity.badRequest().body(sb.toString());
        } else {
            Long newId = service.createTeacher(teacherDto);
            URI uri = URI.create(ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/" + newId).toUriString());
            return ResponseEntity.created(uri).body(newId);
        }
    }

//    @GetMapping("/before")
//    public ResponseEntity<Iterable<Teacher>> getTeachersBefore(@RequestParam LocalDate date) {
//        return ResponseEntity.ok(repos.findByDobBefore(date));
//    }
}
