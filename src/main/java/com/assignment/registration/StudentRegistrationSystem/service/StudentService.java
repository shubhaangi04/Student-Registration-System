package com.assignment.registration.StudentRegistrationSystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.registration.StudentRegistrationSystem.model.Student;
import com.assignment.registration.StudentRegistrationSystem.repository.StudentRepository;

@Service
public class StudentService {

  @Autowired private StudentRepository studentRepository;

  public void addStudent(Student student) {
    studentRepository.save(student);
  }

  public void removeStudent(int id) {
    studentRepository.deleteById(id);
    Optional<Student> optionalStudent = studentRepository.findById(id);
    if (!optionalStudent.isPresent()) {
    	
    }
    studentRepository.delete(optionalStudent.get());
  }

  public Student getStudent(int id) {
    Optional<Student> optionalStudent = studentRepository.findById(id);
    if (!optionalStudent.isPresent()) {
    	
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

  public void updateStudent(int id, Student student) {
	  studentRepository.save(student);
  }
  
}