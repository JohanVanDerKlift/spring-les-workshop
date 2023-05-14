package com.example.les11.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue
    private Long studentNr;
    private String fullName;
    private Long phoneNumber;

    public Long getStudentNr() {
        return studentNr;
    }

    public void setStudentNr(Long studentNr) {
        this.studentNr = studentNr;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
