package com.example.les11.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class TeacherDto {

    public Long id;

    @NotBlank
    public String firstName;

    @Size(min=3, max=128, message = "Grootte tussen 3 en 128")
    public String lastName;

    @Past
    public LocalDate dob;

    @Max(value=100000, message = "Salary is too high")
    public int salary;
}
