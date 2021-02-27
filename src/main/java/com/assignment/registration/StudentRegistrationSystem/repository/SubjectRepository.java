package com.assignment.registration.StudentRegistrationSystem.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.assignment.registration.StudentRegistrationSystem.model.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Integer> {
  public Set<Subject> findByStudentId(int studentId);
}
