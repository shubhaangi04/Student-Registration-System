package com.assignment.registration.StudentRegistrationSystem.controller;

import java.util.HashSet;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.registration.StudentRegistrationSystem.model.Student;
import com.assignment.registration.StudentRegistrationSystem.model.Subject;
import com.assignment.registration.StudentRegistrationSystem.service.SubjectService;

@RestController
public class SubjectController {

  @Autowired private SubjectService subjectService;

  @GetMapping(value = "/students/{id}/subjects/")
  public Subject getSubject(@PathVariable int id) {
    return subjectService.getSubject(id);
  }

  @GetMapping("/students/{id}/subjects/{subjectId}")
  public HashSet<Subject> getAllSubjects(@PathVariable int id) {
    return subjectService.getAllSubjects(id);
  }

  @PostMapping("/students/{id}/subjects/")
  public void addSubject(@Valid @RequestBody Subject subject, @PathVariable int id) {
    subject.setStudent(new Student(id, "", ""));
    subjectService.addSubject(subject);
  }

  @PutMapping(value = "/students/{id}/subjects/{subjectId}")
  public void updateSubject(@Valid @RequestBody Subject subject, @PathVariable int id) {
	  subject.setStudent(new Student(id, "", ""));
	  subjectService.updateSubject(subject);
  }

  @DeleteMapping("/students/{id}/subjects/{subjectId}")
  public void deleteSubject(@PathVariable int id) {
    subjectService.removeSubject(id);
  }
  
  @PutMapping("/registerStudentToSubject/{subjectId}")
	public String enrollStudentsToSubject(@PathVariable int subjectId, @RequestBody Student students) {
		subjectService.registerStudentToSubject(subjectId, students);
		return "Students has been successfully Enrolled to Course :: " + subjectId;
	}
}
