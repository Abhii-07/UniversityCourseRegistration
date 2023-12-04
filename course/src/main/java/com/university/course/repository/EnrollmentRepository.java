package com.university.course.repository;

import com.university.course.model.Course;
import com.university.course.model.Enrollment;
import com.university.course.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
    Optional<Enrollment> findByStudentIdAndCourseId(Integer studentId, Integer courseId);

    boolean existsByStudentAndCourse(Student student, Course course);
}
