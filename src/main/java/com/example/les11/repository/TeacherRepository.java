package com.example.les11.repository;

import com.example.les11.model.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {

    Iterable<Teacher> findByDobBefore(LocalDate date);
}
