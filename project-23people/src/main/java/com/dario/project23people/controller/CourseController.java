package com.dario.project23people.controller;

import com.dario.project23people.model.Course;
import com.dario.project23people.service.CourseService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping("/all")
    public Iterable<Course> getAllCoursesNotPaginated(){
        return courseService.getAllCoursesNotPaginated();
    }

    @GetMapping
    public List<Course> getAllCourses(Pageable paging) {
        return courseService.getAllCourses(paging);
    }
    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id){
        return courseService.getCourseById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public String addCourse(@Valid @RequestBody Course course){
        courseService.addCourse(course);
        return "Course is valid, added: " + course.getName();
    }



    @PutMapping("/{id}")
    public String updateCourse(@Valid @PathVariable Long id, @RequestBody Course course){
        return courseService.updateCourse(id, course);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable Long id){
        return courseService.deleteCourse(id);
    }

}
