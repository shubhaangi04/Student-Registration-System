package com.assignment.registration.StudentRegistrationSystem.service;

import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.registration.StudentRegistrationSystem.exception.StudentSubjectIllegalStateException;
import com.assignment.registration.StudentRegistrationSystem.model.Student;
import com.assignment.registration.StudentRegistrationSystem.model.Subject;
import com.assignment.registration.StudentRegistrationSystem.repository.SubjectRepository;

@Service
public class SubjectService {

  @Autowired private SubjectRepository subjectRepository;

  public String addSubject(Subject subject) {
    subjectRepository.save(subject);
    return "Saved";
  }

  public void removeSubject(int studentId) {
    subjectRepository.deleteById(studentId);
  }

  public HashSet<Subject> getAllSubjects(int studentId) {
    HashSet<Subject> subjects = new HashSet<Subject>();
    subjectRepository.findByStudentId(studentId).forEach(subjects::add);
    return subjects;
  }

  public Subject getSubject(int id) {
    Optional<Subject> optionalSubject = subjectRepository.findById(id);
    if (!optionalSubject.isPresent()) {
      throw new StudentSubjectIllegalStateException(
          "Failed to get subject because subject with " + id + " doesn't exist!");
    }
    Subject subject = optionalSubject.get();
    return subject;
  }

  public void updateSubject(Subject newSubject) {
    subjectRepository.save(newSubject);
  }

  public void registerStudentToSubject(int subjectId, Student student) {
    Optional<Subject> optionalSubject = subjectRepository.findById(subjectId);
    if (!optionalSubject.isPresent()) {
      throw new StudentSubjectIllegalStateException(
          "Failed to register Student because " + subjectId + " doesn't exist!");
    }
    Subject subject = optionalSubject.get();
    subject.setStudent(student);
    subjectRepository.save(subject);
  }
}
