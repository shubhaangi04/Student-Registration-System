package com.assignment.registration.StudentRegistrationSystem.exception;

public class StudentSubjectIllegalStateException extends IllegalStateException {

  private static final long serialVersionUID = 1L;

  public StudentSubjectIllegalStateException(String message) {
    super(message);
  }

  public StudentSubjectIllegalStateException(Throwable e) {
    super(e);
  }
}
