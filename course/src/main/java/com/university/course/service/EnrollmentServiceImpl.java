package com.university.course.service;

import com.university.course.model.Course;
import com.university.course.model.Enrollment;
import com.university.course.model.EnrollmentDetails;
import com.university.course.model.Student;
import com.university.course.repository.CourseRepository;
import com.university.course.repository.EnrollmentRepository;
import com.university.course.repository.StudentRepository;
import com.university.course.exception.EnrollmentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    EnrollmentRepository enrollmentRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Enrollment enrollStudent(Integer studentId, Integer courseId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EnrollmentException("Student not found with ID: " + studentId));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new EnrollmentException("Course not found with ID: " + courseId));

        // Check if the student is already enrolled in the course
        boolean isEnrolled = enrollmentRepository.existsByStudentAndCourse(student, course);
        if (isEnrolled) {
            throw new EnrollmentException("Student is already enrolled in this course.");
        }

        Enrollment newEnrollment = new Enrollment();
        newEnrollment.setStudent(student);
        newEnrollment.setCourse(course);
        newEnrollment.setEnrollmentDate(new Date());

        return enrollmentRepository.save(newEnrollment);
    }

    public EnrollmentDetails getEnrollmentDetails(Integer enrollmentId) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new EnrollmentException("Enrollment not found with ID: " + enrollmentId));

        EnrollmentDetails enrollmentDetails = new EnrollmentDetails();
        enrollmentDetails.setEnrollmentId(enrollment.getId());
        enrollmentDetails.setEnrollmentDate(enrollment.getEnrollmentDate());

        Student student = enrollment.getStudent();
        enrollmentDetails.setStudentId(student.getId());
        enrollmentDetails.setStudentName(student.getName());

        Course course = enrollment.getCourse();
        enrollmentDetails.setCourseId(course.getId());
        enrollmentDetails.setCourseName(course.getName());

        return enrollmentDetails;
    }


    @Override
    public void updateEnrollment(Enrollment enrollment) {
        // Validate if the enrollment exists before updating
        enrollmentRepository.findById(enrollment.getId()).orElseThrow(() ->
                new EnrollmentException("Enrollment not found with ID: " + enrollment.getId()));
        enrollmentRepository.save(enrollment);
    }

    @Override
    public void deleteEnrollment(Integer enrollmentId) {
        enrollmentRepository.deleteById(enrollmentId);
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    @Override
    public List<EnrollmentDetails> getAllEnrollmentsWithDetails() {
        List<Enrollment> enrollments = enrollmentRepository.findAll();
        List<EnrollmentDetails> enrollmentDetailsList = new ArrayList<>();

        for (Enrollment enrollment : enrollments) {
            EnrollmentDetails enrollmentDetails = new EnrollmentDetails();
            enrollmentDetails.setEnrollmentId(enrollment.getId());
            enrollmentDetails.setEnrollmentDate(enrollment.getEnrollmentDate());

            Student student = enrollment.getStudent();
            enrollmentDetails.setStudentId(student.getId());
            enrollmentDetails.setStudentName(student.getName());

            Course course = enrollment.getCourse();
            enrollmentDetails.setCourseId(course.getId());
            enrollmentDetails.setCourseName(course.getName());

            enrollmentDetailsList.add(enrollmentDetails);
        }

        return enrollmentDetailsList;
    }
}
