package com.fernandodev.studentmanagersystem;

import com.fernandodev.studentmanagersystem.entities.Student;
import com.fernandodev.studentmanagersystem.services.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentManagerSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagerSystemApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner demo(StudentService studentService){
//        return (args) -> {
//            Student stud2 = new Student();
//            stud2.setEmail("fernando@gmail.com");
//            stud2.setName("fernando");
//            studentService.save(stud2);
//
//            System.out.println(studentService.getAllStudents());
//        };
//    }
}
