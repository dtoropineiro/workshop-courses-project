package com.dario.project23people.service;

import com.dario.project23people.exception.EntityNotFoundException;
import com.dario.project23people.model.Student;
import com.dario.project23people.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    private static final Logger LOGGER = Logger.getLogger("com.dario.project23people.service.StudentService");
    private static final String STUDENT_NOT_FOUND = "Student not found";


    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public String addStudent(Student student) {
        studentRepository.save(student);
        return "Added student with id: " + student.getId();
    }

    @Override
    public String updateStudent(Long id, Student student) {
        if (!studentRepository.findById(id).isPresent()){

            throw new EntityNotFoundException(STUDENT_NOT_FOUND);
        }
        student.setId(id);
        studentRepository.save(student);
        return "updated student with id: " + id;
    }

    @Override
    public String deleteStudent(Long id) {
        if (!studentRepository.findById(id).isPresent()){
            LOGGER.log(Level.WARNING, STUDENT_NOT_FOUND);
            throw new EntityNotFoundException(STUDENT_NOT_FOUND);
        }
        studentRepository.deleteById(id);
        return "deleted student with id: " + id;
    }

    @Override
    public Iterable<Student> getAllStudentsNotPaginated() {
        return studentRepository.findAll();
    }


}
