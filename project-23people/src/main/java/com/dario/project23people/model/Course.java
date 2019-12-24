package com.dario.project23people.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "COURSE")
public class Course {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course", cascade= CascadeType.MERGE)
    private List<Student> students;

    //private StudentsName
    @NotEmpty
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getStudentsByName(){
        List<String> list = students.stream().map(s -> s.getName() + " " + s.getGender()).collect(Collectors.toList());
        return list;
    }
}
