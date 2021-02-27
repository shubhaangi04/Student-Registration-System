package com.assignment.registration.StudentRegistrationSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Subject")
public class Subject {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int subjectId;

  @ManyToOne
  @JoinColumn(name = "student_id", nullable = false)
  private Student student;

  public Subject() {}
  
  public Subject(
      int subjectId,
      Student student,
      String subjectName,
      String subjectDescription,
      String subjectStartTime,
      String subjectEndTime,
      int studentId) {
    super();
    this.subjectId = subjectId;
    this.student = student;
    this.subjectName = subjectName;
    this.subjectDescription = subjectDescription;
    this.subjectStartTime = subjectStartTime;
    this.subjectEndTime = subjectEndTime;
    this.student = new Student(studentId, "", "");
  }

  @NotBlank(message = "Name is mandatory")
  @Column(unique = true)
  private String subjectName;

  @NotBlank(message = "Description is mandatory")
  private String subjectDescription;

  @NotBlank(message = "Start time is mandatory")
  private String subjectStartTime;

  @NotBlank(message = "End time is mandatory")
  private String subjectEndTime;

  public int getSubjectId() {
    return subjectId;
  }

  public void setSubjectId(int subjectId) {
    this.subjectId = subjectId;
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

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }
}
