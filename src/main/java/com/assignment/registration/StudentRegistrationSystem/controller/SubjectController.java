package com.assignment.registration.StudentRegistrationSystem.controller;

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

import com.assignment.registration.StudentRegistrationSystem.model.Subject;
import com.assignment.registration.StudentRegistrationSystem.service.SubjectService;

@RestController
public class SubjectController {

	@Autowired private SubjectService subjectService;
	
	@GetMapping(value = "/subjects/{id}")
	  public ResponseEntity<?> getSubject(@PathVariable int id) {
		return new ResponseEntity<Subject>(subjectService.getSubject(id), new HttpHeaders(), HttpStatus.OK);
	  }

	  @GetMapping("/subjects")
	  public List<Subject> getSubjects() {
	    return subjectService.getAllSubjects();
	  }

	  @PostMapping("/subjects")
	  public ResponseEntity<?> createSubject(@Valid @RequestBody Subject subject) {
		  subjectService.addSubject(subject);
		  return new ResponseEntity<>("Subject successfully created", new HttpHeaders(), HttpStatus.OK);
	  }

	  @PutMapping(value = "/subjects/{id}")
	  public Subject updateStudent(@PathVariable int id, @Valid @RequestBody Subject subject) {
	    return subjectService.updateSubject(id, subject);
	  }

	  @DeleteMapping("/subjects/{id}")
	  public ResponseEntity<?> deleteSubject(@PathVariable int id) {
	    subjectService.removeSubject(id);
	    return new ResponseEntity<>("Subject successfully deleted", new HttpHeaders(), HttpStatus.OK);
	  }
 }
