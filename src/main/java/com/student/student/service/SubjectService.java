package com.student.student.service;

import com.student.student.model.Professor;
import com.student.student.model.Subject;
import com.student.student.repository.CourseRepository;
import com.student.student.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private CourseRepository courseRepository;

    public List<Subject> getAllSubjects(){
        return subjectRepository.findAll();
    }
    @Transactional
    public ResponseEntity<Object> addSubject(Subject subject){
        Subject newSubject = new Subject();
        newSubject.setSubjectName(subject.getSubjectName());

        newSubject.setProfessors(subject.getProfessors());
        Subject savedSubject = subjectRepository.save(newSubject);
        if (subjectRepository.findById(savedSubject.getId()).isPresent()){
            return ResponseEntity.accepted().body("Successfully Added");
        }else
            return ResponseEntity.unprocessableEntity().body("Failed to Add");
    }

}
