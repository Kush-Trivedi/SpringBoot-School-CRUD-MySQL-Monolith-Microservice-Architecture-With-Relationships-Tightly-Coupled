package com.student.student.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "professor")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",updatable = false,nullable = false)
    private Long id;

    @Column(name = "professor_name")
    private String professorName;

    @Column
    private String professorLastName;

    @Column
    private String professorPositionTitle;

    @Column
    private String professorEmail;

    @Column
    private String professorPhoneNumber;

    @Column
    private String professorOfficeLocation;

    @Column
    private Integer professorExperienceYears;

    @Column
    private Integer professorResearchWork;

    @Lob
    private byte[] professorImage;

    @JsonIgnore
    @ManyToOne
    private Subject subject;

    @OneToMany(targetEntity = Student.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "professor_id")
    private Set<Student>students = new TreeSet<>();

    public Professor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public String getProfessorLastName() {
        return professorLastName;
    }

    public void setProfessorLastName(String professorLastName) {
        this.professorLastName = professorLastName;
    }

    public String getProfessorPositionTitle() {
        return professorPositionTitle;
    }

    public void setProfessorPositionTitle(String professorPositionTitle) {
        this.professorPositionTitle = professorPositionTitle;
    }

    public String getProfessorEmail() {
        return professorEmail;
    }

    public void setProfessorEmail(String professorEmail) {
        this.professorEmail = professorEmail;
    }

    public String getProfessorPhoneNumber() {
        return professorPhoneNumber;
    }

    public void setProfessorPhoneNumber(String professorPhoneNumber) {
        this.professorPhoneNumber = professorPhoneNumber;
    }

    public String getProfessorOfficeLocation() {
        return professorOfficeLocation;
    }

    public void setProfessorOfficeLocation(String professorOfficeLocation) {
        this.professorOfficeLocation = professorOfficeLocation;
    }


    public Integer getProfessorExperienceYears() {
        return professorExperienceYears;
    }

    public void setProfessorExperienceYears(Integer professorExperienceYears) {
        this.professorExperienceYears = professorExperienceYears;
    }

    public Integer getProfessorResearchWork() {
        return professorResearchWork;
    }

    public void setProfessorResearchWork(Integer professorResearchWork) {
        this.professorResearchWork = professorResearchWork;
    }


    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public byte[] getProfessorImage() {
        return professorImage;
    }

    public void setProfessorImage(byte[] professorImage) {
        this.professorImage = professorImage;
    }
}
