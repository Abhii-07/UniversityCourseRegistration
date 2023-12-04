package com.university.course.service;

import com.university.course.model.Course;
import com.university.course.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Integer id);
    Student registerStudent(Student student);
    Student updateStudent(Student student);
    void deleteStudent(Integer id);
    List<Course> getCoursesForStudent(Integer studentId);
}

