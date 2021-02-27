package com.assignment.registration.StudentRegistrationSystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.assignment.registration.StudentRegistrationSystem.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{
	
}
