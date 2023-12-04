package com.university.course.repository;

import com.university.course.model.Enrollment;
import com.university.course.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findWithEnrollmentsById(Integer studentId);
}
