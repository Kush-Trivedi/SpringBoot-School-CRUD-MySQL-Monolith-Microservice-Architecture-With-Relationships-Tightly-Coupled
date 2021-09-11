package com.student.student.controller;

import com.student.student.model.Professor;
import com.student.student.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping("/addProfessor")
    public ResponseEntity<Object> addProfessor(@RequestBody Professor professor){
        return professorService.addProfessor(professor);
    }

    @GetMapping("/professorList")
    public List<Professor> getAllProfessors(){
        return professorService.getAllProfessors();
    }
}
