package com.fernandodev.studentmanagersystem.controller;


import com.fernandodev.studentmanagersystem.entities.Student;
import com.fernandodev.studentmanagersystem.services.StudentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("students")
public class StudentController {

    //TODO:
    // REFATORAR A CRIAÇÃO DE ID
    

    private StudentService studentService;

    public StudentController() {
    }

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<List<Student>>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable String id) {
        Optional<Student> std1 = studentService.getStudent(Integer.parseInt(id));

        if (std1.isPresent()) {
            return new ResponseEntity<>(std1, HttpStatus.OK);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Id not found");
        }
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Student> createStudent(@RequestBody Student newStudent){
        if(newStudent == null){
            throw new RuntimeException("Student is null");
        } else {
            studentService.save(newStudent);
            return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
        }
    }

    @GetMapping("/buscar-nome")
    public ResponseEntity<?> getStudentsPorNome(@RequestParam String nome){
        List<Student> students = studentService.getStudentContainingName(nome);

        if(students.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No students with current name found.");
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(students);
        }
    }
}
