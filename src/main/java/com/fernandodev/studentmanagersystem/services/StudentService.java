package com.fernandodev.studentmanagersystem.services;

import com.fernandodev.studentmanagersystem.entities.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    void save(Student student);
    List<Student> getAllStudents();
    Optional<Student> getStudent(Integer studentId);
}
