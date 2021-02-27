package com.assignment.registration.StudentRegistrationSystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.registration.StudentRegistrationSystem.exception.StudentSubjectIllegalStateException;
import com.assignment.registration.StudentRegistrationSystem.model.Student;
import com.assignment.registration.StudentRegistrationSystem.repository.StudentRepository;

@Service
public class StudentService {

  @Autowired private StudentRepository studentRepository;

  public void addStudent(Student student) {
    studentRepository.save(student);
  }

  public String removeStudent(int id) {
    studentRepository.deleteById(id);
    Optional<Student> optionalStudent = studentRepository.findById(id);
    if (!optionalStudent.isPresent()) {
    	throw new StudentSubjectIllegalStateException("Failed to remove student because student with " + id + " doesn't exist!");
    }
    studentRepository.delete(optionalStudent.get());
    return "deleted";
  }

  public Student getStudent(int id) {
    Optional<Student> optionalStudent = studentRepository.findById(id);
    if (!optionalStudent.isPresent()) {
    	throw new StudentSubjectIllegalStateException("Failed to get student because student with " + id + " doesn't exist!");
    }

    Student student = optionalStudent.get();
    return student;
  }

  public List<Student> getAllStudents() {
    List<Student> students = new ArrayList<Student>();
    Iterable<Student> itr = studentRepository.findAll();
    for (Student student : itr) {
      students.add(student);
    }
    return students;
  }

  public Student updateStudent(int id, Student newStudent) {
    return studentRepository
        .findById(id)
        .map(
            student -> {
              student.setStudentName(newStudent.getStudentName());
              student.setStudentEmail(newStudent.getStudentEmail());
              student.setSubjects(newStudent.getSubjects());
              return studentRepository.save(student);
            })
        .orElseGet(
            () -> {
              newStudent.setStudentId(id);
              return studentRepository.save(newStudent);
            });
  }
  
}
