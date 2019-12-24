package com.dario.project23people.service;

import com.dario.project23people.exception.EntityNotFoundException;
import com.dario.project23people.model.Course;
import com.dario.project23people.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;
@Service
public class CourseServiceImpl implements CourseService {

    private static final Logger LOGGER = Logger.getLogger("com.dario.project23people.service.CourseService");
    private static final String COURSE_NOT_FOUND = "Course not found";
    private CourseRepository courseRepository;

    public CourseServiceImpl(){
    }

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public Iterable<Course> getAllCoursesNotPaginated() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> getAllCourses(Pageable paging) {
        Page<Course> pagedResult = courseRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public String addCourse(Course course) {
        courseRepository.save(course);
        return "Added course with id: " + course.getId();
    }

    @Override
    public Course getCourseById(Long id){
        return courseRepository.findById(id).orElseThrow(() -> {
            LOGGER.log(Level.WARNING, COURSE_NOT_FOUND);
            return new EntityNotFoundException(COURSE_NOT_FOUND);
        });

    }

    @Override
    public String deleteCourse(Long id) throws EntityNotFoundException {
        if (!courseRepository.findById(id).isPresent()){
            throw new EntityNotFoundException(COURSE_NOT_FOUND);
        }
        courseRepository.deleteById(id);
        return "deleted course with id: " + id;
    }

    @Override
    public String updateCourse(Long id, Course course) throws EntityNotFoundException {
        if (!courseRepository.findById(id).isPresent()){
            throw new EntityNotFoundException(COURSE_NOT_FOUND);
        }
        course.setId(id);
        courseRepository.save(course);
        return "updated course with id: " + id;
    }

}
