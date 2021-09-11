package com.student.student.controller;

import com.student.student.model.Subject;
import com.student.student.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/addSubject")
    public ResponseEntity<Object> addSubject(@RequestBody Subject subject){
        return subjectService.addSubject(subject);
    }

    @GetMapping("/subjectList")
    public List<Subject> getAllSubjects(){
        return subjectService.getAllSubjects();
    }
}
