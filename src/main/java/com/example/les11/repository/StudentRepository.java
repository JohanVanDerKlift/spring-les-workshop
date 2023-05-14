package com.example.les11.repository;

import com.example.les11.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

    Iterable<Student> findByFullNameContainingIgnoreCaseOrderByFullName(String name);

}
