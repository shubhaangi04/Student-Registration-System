package com.assignment.registration.StudentRegistrationSystem.controller;

import java.util.HashSet;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.registration.StudentRegistrationSystem.model.Student;
import com.assignment.registration.StudentRegistrationSystem.model.Subject;
import com.assignment.registration.StudentRegistrationSystem.service.StudentService;
import com.assignment.registration.StudentRegistrationSystem.service.SubjectService;

@RestController
public class StudentController {

  @Autowired private StudentService studentService;
  @Autowired private SubjectService subjectService;

  @GetMapping(value = "/students/{id}")
  public ResponseEntity<?> getStudentById(@PathVariable int id) {
	Student student = studentService.getStudent(id);
    return new ResponseEntity<>(student, new HttpHeaders(), HttpStatus.OK);
  }

  @GetMapping("/students")
  public List<Student> getStudents() {
    return studentService.getAllStudents();
  }

  @PostMapping("/students")
  public ResponseEntity<?> createStudent(@Valid @RequestBody Student student) {
    studentService.addStudent(student);
    return new ResponseEntity<>("Student successfully created", new HttpHeaders(), HttpStatus.OK);
  }

  @PutMapping(value = "/students/{id}")
  public ResponseEntity<?> updateStudent(@Valid @PathVariable int id, @RequestBody Student student) {
    studentService.updateStudent(id, student);
    return new ResponseEntity<>("Student successfully updated", new HttpHeaders(), HttpStatus.OK);
  }

  @DeleteMapping("/students/{id}")
  public ResponseEntity<?> deleteStudent(@PathVariable int id) {
    studentService.removeStudent(id);
    return new ResponseEntity<>("Student successfully deleted", new HttpHeaders(), HttpStatus.OK);
  }
  
  @GetMapping(value = "/students/{id}/subjects/")
  public Subject getSubject(@PathVariable int id) {
    return subjectService.getSubjectByStudent(id);
  }

  @GetMapping("/students/{id}/subjects/{subjectId}")
  public HashSet<Subject> getAllSubjects(@PathVariable int id) {
    return subjectService.getAllSubjectsForStudent(id);
  }

  @PostMapping("/students/{id}/subjects/")
  public void addSubject(@Valid @RequestBody Subject subject, @PathVariable int id) {
//    subject.setStudent(new Student(id, "", ""));
    subjectService.addSubject(subject);
  }

  @PutMapping(value = "/students/{id}/subjects/{subjectId}")
  public void updateSubject(@Valid @RequestBody Subject subject, @PathVariable int id) {
//	  subject.setStudent(new Student(id, "", ""));
	  subjectService.updateSubject(subject);
  }

  @DeleteMapping("/students/{id}/subjects/{subjectId}")
  public void deleteSubject(@PathVariable int id) {
    subjectService.removeSubjectForStudent(id);
  }
  
}
