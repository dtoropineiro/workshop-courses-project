package com.dario.project23people.controller;

import com.dario.project23people.model.Student;
import com.dario.project23people.service.StudentService;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@EnableEurekaClient
@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public Iterable<Student> getAllStudentsNotPaginated(){
        return studentService.getAllStudentsNotPaginated();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public String addStudent(@Valid @RequestBody Student student){
        studentService.addStudent(student);
        return "Student is valid, added: " + student.getName();
    }

    @PutMapping("/{id}")
    public String updateStudent(@Valid @PathVariable Long id, @Valid @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }
}
