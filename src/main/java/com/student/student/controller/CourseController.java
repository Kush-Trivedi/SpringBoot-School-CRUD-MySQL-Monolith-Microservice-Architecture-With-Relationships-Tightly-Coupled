package com.student.student.controller;

import com.student.student.model.Course;
import com.student.student.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CourseController {

    @Autowired
    public CourseService courseService;

    @PostMapping("/addCourse")
    public ResponseEntity<Object> addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @GetMapping("/courselist")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }





}
