package com.fernandodev.studentmanagersystem.repository;

import com.fernandodev.studentmanagersystem.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
