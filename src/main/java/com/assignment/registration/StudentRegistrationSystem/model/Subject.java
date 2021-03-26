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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "subject")
public class Subject {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private int studentId;

  @ManyToMany(
      mappedBy = "subjectList")
  private Set<Student> students ;//= new HashSet<>();

  public Subject() {}

  public Subject(
      int subjectId,
      String subjectName,
      String subjectDescription,
      String subjectStartTime,
      String subjectEndTime) {
    this.id = subjectId;
    this.subjectName = subjectName;
    this.subjectDescription = subjectDescription;
    this.subjectStartTime = subjectStartTime;
    this.subjectEndTime = subjectEndTime;
  }

  @NotBlank(message = "name is mandatory")
  @Column(unique = true)
  private String subjectName;

  @NotBlank(message = "description is mandatory")
  private String subjectDescription;

  @NotBlank(message = "start time is mandatory")
  private String subjectStartTime;

  @NotBlank(message = "end time is mandatory")
  private String subjectEndTime;

  public int getId() {
    return id;
  }

  public void setId(int subjectId) {
    this.id = subjectId;
  }

  public String getSubjectName() {
    return subjectName;
  }

  public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
  }

  public String getSubjectDescription() {
    return subjectDescription;
  }

  public void setSubjectDescription(String subjectDescription) {
    this.subjectDescription = subjectDescription;
  }

  public String getSubjectStartTime() {
    return subjectStartTime;
  }

  public void setSubjectStartTime(String subjectStartTime) {
    this.subjectStartTime = subjectStartTime;
  }

  public String getSubjectEndTime() {
    return subjectEndTime;
  }

  public void setSubjectEndTime(String subjectEndTime) {
    this.subjectEndTime = subjectEndTime;
  }

  public Set<Student> getStudent() {
    return students;
  }

  public void setStudent(Set<Student> student) {
    this.students = student;
  }

  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }
}
