package com.student.student.service;

import com.student.student.model.Professor;
import com.student.student.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> getAllProfessors(){
        return professorRepository.findAll();
    }

    @Transactional
    public ResponseEntity<Object>addProfessor(Professor professor){
        Professor newProfessor = new Professor();
        newProfessor.setProfessorName(professor.getProfessorName());
        newProfessor.setProfessorLastName(professor.getProfessorLastName());
        newProfessor.setProfessorPositionTitle(professor.getProfessorPositionTitle());
        newProfessor.setProfessorEmail(professor.getProfessorEmail());
        newProfessor.setProfessorPhoneNumber(professor.getProfessorPhoneNumber());
        newProfessor.setProfessorOfficeLocation(professor.getProfessorOfficeLocation());
        newProfessor.setProfessorExperienceYears(professor.getProfessorExperienceYears());
        newProfessor.setProfessorResearchWork(professor.getProfessorResearchWork());
        newProfessor.setProfessorImage(professor.getProfessorImage());


        newProfessor.setStudents(professor.getStudents());
        Professor savedProfessor = professorRepository.save(newProfessor);
        if(professorRepository.findById(savedProfessor.getId()).isPresent()){
            return ResponseEntity.accepted().body("Successfully Added");
        }else
            return ResponseEntity.unprocessableEntity().body("Failed to Add");
    }

}
