package com.student.student.service;

import com.student.student.model.Course;
import com.student.student.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    public CourseRepository courseRepository;


    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    @Transactional
    public ResponseEntity<Object> addCourse(Course course){
        Course newCourse = new Course();
        newCourse.setCourseName(course.getCourseName());
        newCourse.setSubjects(course.getSubjects());
        Course savedCourse = courseRepository.save(newCourse);
        if (courseRepository.findById(savedCourse.getId()).isPresent()){
            return ResponseEntity.accepted().body("Successfully Added");
        }else
            return ResponseEntity.unprocessableEntity().body("Failed to Add");
    }

}
