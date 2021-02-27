package com.assignment.registration.StudentRegistrationSystem.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Student")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotBlank(message = "Name is mandatory")
  @Size(min=2, message="Name should have atleast 2 characters")
  private String studentName;

  @Column(unique = true)
  private String studentEmail;

  @OneToMany(targetEntity = Subject.class, cascade = CascadeType.ALL)
  Set<Subject> subjectList;

  public Student() {}
  
  public Student(int studentId,String studentName,String studentEmail){
	  super();
	  this.id = studentId;
	  this.studentName = studentName;
	  this.studentEmail = studentEmail;
  }

public Integer getStudentId() {
    return id;
  }

  public void setStudentId(Integer studentId) {
    id = studentId;
  }

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public String getStudentEmail() {
    return studentEmail;
  }

  public void setStudentEmail(String studentEmail) {
    this.studentEmail = studentEmail;
  }

  public Set<Subject> getSubjects() {
    return subjectList;
  }

  public void setSubjects(Set<Subject> subjects) {
    this.subjectList = subjects;
  }
}
