package com.fernandodev.studentmanagersystem.services;

import com.fernandodev.studentmanagersystem.entities.Student;
import com.fernandodev.studentmanagersystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    StudentRepository studentRepository;

    public StudentServiceImpl(){}

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepo){
        this.studentRepository = studentRepo;
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudent(Integer studentId) {
        return studentRepository.findById(studentId);
    }
}
