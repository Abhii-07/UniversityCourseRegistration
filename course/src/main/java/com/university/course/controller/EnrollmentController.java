package com.university.course.controller;

import com.university.course.model.Enrollment;
import com.university.course.model.EnrollmentDetails;
import com.university.course.model.Student;
import com.university.course.service.EnrollmentServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentServiceImpl enrollmentService;

    @PostMapping("/enroll")
    public ResponseEntity<String> enrollStudent(@RequestParam Integer studentId, @RequestParam Integer courseId) {
        Enrollment newEnrollment = enrollmentService.enrollStudent(studentId, courseId);
        String successMessage = "Enrolled successfully for student ID: " + studentId + " in course ID: " + courseId;
        return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EnrollmentDetails>> getAllEnrollmentsWithDetails() {
        try {
            List<EnrollmentDetails> enrollmentDetails = enrollmentService.getAllEnrollmentsWithDetails();
            return new ResponseEntity<>(enrollmentDetails, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDetails> getEnrollmentDetails(@PathVariable Integer id) {
        try {
            EnrollmentDetails enrollmentDetails = enrollmentService.getEnrollmentDetails(id);
            return new ResponseEntity<>(enrollmentDetails, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEnrollment(@PathVariable Integer id, @RequestBody Enrollment enrollment) {
        enrollment.setId(id);
        enrollmentService.updateEnrollment(enrollment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Integer id) {
        enrollmentService.deleteEnrollment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
