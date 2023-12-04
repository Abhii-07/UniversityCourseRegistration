package com.university.course.service;

import com.university.course.model.Course;
import com.university.course.model.Enrollment;
import com.university.course.model.EnrollmentDetails;
import com.university.course.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EnrollmentService {
    Enrollment enrollStudent(Integer studentId, Integer courseId);
    void updateEnrollment(Enrollment enrollment);
    void deleteEnrollment(Integer enrollmentId);

    EnrollmentDetails getEnrollmentDetails(Integer enrollmentId);

    List<EnrollmentDetails> getAllEnrollmentsWithDetails();
    List<Enrollment> getAllEnrollments();
}
