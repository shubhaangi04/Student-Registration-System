package com.assignment.registration.StudentRegistrationSystem.controller;

import java.util.List;

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
import com.assignment.registration.StudentRegistrationSystem.service.StudentService;

@RestController
public class StudentController {

  @Autowired private StudentService studentService;

  @GetMapping(value = "/students/{id}")
  public Student getStudentById(@PathVariable int id) {
    return studentService.getStudent(id);
  }

  @GetMapping("/students")
  public List<Student> getStudents() {
    return studentService.getAllStudents();
  }

  @PostMapping("/students")
  public void createStudent(@Valid @RequestBody Student student) {
    studentService.addStudent(student);
  }

  @PutMapping(value = "/students/{id}")
  public Student updateStudent(@Valid @PathVariable int id, @RequestBody Student student) {
    return studentService.updateStudent(id, student);
  }

  @DeleteMapping("/students/{id}")
  public String deleteStudent(@PathVariable int id) {
    return studentService.removeStudent(id);
  }
}
