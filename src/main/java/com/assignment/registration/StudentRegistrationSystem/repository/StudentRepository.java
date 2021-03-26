package com.assignment.registration.StudentRegistrationSystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.registration.StudentRegistrationSystem.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>{
	
}
