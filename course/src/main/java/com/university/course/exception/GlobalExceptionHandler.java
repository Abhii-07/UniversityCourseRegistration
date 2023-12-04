package com.university.course.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(StudentException.class)
    public ResponseEntity<MyErrorDetails> handleStudentException(StudentException se, WebRequest req) {
        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), se.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    // Handle CourseException
    @ExceptionHandler(CourseException.class)
    public ResponseEntity<MyErrorDetails> handleCourseException(CourseException ce, WebRequest req) {
        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), ce.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    // Handle EnrollmentException
    @ExceptionHandler(EnrollmentException.class)
    public ResponseEntity<MyErrorDetails> handleEnrollmentException(EnrollmentException ee, WebRequest req) {
        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
}

