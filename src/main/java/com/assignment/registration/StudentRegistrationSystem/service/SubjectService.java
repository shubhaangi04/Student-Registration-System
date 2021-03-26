package com.assignment.registration.StudentRegistrationSystem.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.registration.StudentRegistrationSystem.model.Subject;
import com.assignment.registration.StudentRegistrationSystem.repository.SubjectRepository;

@Service
public class SubjectService {

  @Autowired private SubjectRepository subjectRepository;

  public String addSubject(Subject subject) {
    subjectRepository.save(subject);
    return "Saved";
  }

  public void removeSubjectForStudent(int studentId) {
    subjectRepository.deleteById(studentId);
  }

  public HashSet<Subject> getAllSubjectsForStudent(int studentId) {
    HashSet<Subject> subjects = new HashSet<Subject>();
    subjectRepository.findByStudentId(studentId).forEach(subjects::add);
    return subjects;
  }

  public List<Subject> getAllSubjects() {
    List<Subject> subjects = new ArrayList<Subject>();
    subjectRepository.findAll().forEach(subjects::add);
    return subjects;
  }

  public Subject getSubjectByStudent(int id) {
    Optional<Subject> optionalSubject = subjectRepository.findById(id);
    if (!optionalSubject.isPresent()) {}

    return optionalSubject.get();
  }

  public Subject getSubject(int id) {
    Optional<Subject> optionalSubject = subjectRepository.findById(id);
    if (!optionalSubject.isPresent()) {}

    return optionalSubject.get();
  }

  public void updateSubject(Subject newSubject) {
    subjectRepository.save(newSubject);
  }

  public List<Subject> getAllSubject() {
    List<Subject> subjects = new ArrayList<Subject>();
    Iterable<Subject> itr = subjectRepository.findAll();
    for (Subject subject : itr) {
      subjects.add(subject);
    }
    return subjects;
  }

  public Subject updateSubject(int id, Subject newSubject) {
    return subjectRepository.save(newSubject);
  }

  public void removeSubject(int id) {
    subjectRepository.deleteById(id);
  }
}
