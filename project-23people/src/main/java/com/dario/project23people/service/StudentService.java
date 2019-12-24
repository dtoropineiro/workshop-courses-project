package com.dario.project23people.service;

import com.dario.project23people.model.Student;

import java.util.List;

public interface StudentService {
    String addStudent(Student student);
    String updateStudent(Long id, Student student);
    String deleteStudent(Long id);
    Iterable<Student> getAllStudentsNotPaginated();
}
