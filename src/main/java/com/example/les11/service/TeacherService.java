package com.example.les11.service;

import com.example.les11.dto.TeacherDto;
import com.example.les11.exception.ResourceNotFoundException;
import com.example.les11.model.Teacher;
import com.example.les11.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository repos;

    public TeacherService(TeacherRepository repos) {
        this.repos = repos;
    }

    public TeacherDto getTeacher(Long id) {
        Teacher t = repos.findById(id).orElseThrow(() -> new ResourceNotFoundException("Teacher not Found"));

        TeacherDto teacherDto = new TeacherDto();
        teacherDto.id = t.getId();
        teacherDto.firstName = t.getFirstName();
        teacherDto.lastName = t.getLastName();
        teacherDto.dob = t.getDob();
        teacherDto.salary = t.getSalary();

        return teacherDto;
    }

    public List<TeacherDto> getTeachers() {
        Iterable<Teacher> teachers = repos.findAll();
        List<TeacherDto> teacherDtos = new ArrayList<>();
        for (Teacher t : teachers) {
            TeacherDto teacherDto = new TeacherDto();
            teacherDto.id = t.getId();
            teacherDto.firstName = t.getFirstName();
            teacherDto.lastName = t.getLastName();
            teacherDto.dob = t.getDob();
            teacherDto.salary = t.getSalary();
            teacherDtos.add(teacherDto);
        }
        return teacherDtos;
    }

    public Long createTeacher(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherDto.firstName);
        teacher.setLastName(teacherDto.lastName);
        teacher.setDob(teacherDto.dob);
        teacher.setSalary(teacherDto.salary);
        repos.save(teacher);
        return teacher.getId();
    }
}
