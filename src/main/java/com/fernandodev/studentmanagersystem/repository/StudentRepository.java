package com.fernandodev.studentmanagersystem.repository;

import com.fernandodev.studentmanagersystem.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByNameContainingIgnoreCase(String nome);
}
