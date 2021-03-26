package com.assignment.registration.StudentRegistrationSystem.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Student")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotBlank(message = "name is mandatory")
  @Size(min = 2, message = "name should have atleast 2 characters")
  private String studentName;

  @Column(unique = true)
  private String studentEmail;

  @ManyToMany(
      fetch = FetchType.LAZY,
      cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(
      name = "student_subject",
      joinColumns = {@JoinColumn(name = "id")},
      inverseJoinColumns = @JoinColumn(name = "subjectId"))
  Set<Subject> subjectList = new HashSet<>();

  public Student() {}

  public Student(int studentId, String studentName, String studentEmail) {
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
