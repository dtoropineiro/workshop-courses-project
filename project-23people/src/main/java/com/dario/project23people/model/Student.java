package com.dario.project23people.model;

import com.dario.project23people.validator.StudentRutConstraint;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "STUDENT")
public class Student{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Min(1)
    private Long id;
    private String name;
    private Integer age;
    @Size(max = 1)
    private String gender;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade= CascadeType.MERGE)
    @JoinColumn(name = "COURSEID", nullable = false)
    private Course course;

    @NotEmpty
    @Size(max = 10)
    @StudentRutConstraint
    private String rut;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
}
