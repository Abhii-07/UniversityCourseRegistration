package com.university.course.service;

import com.university.course.model.Course;
import com.university.course.model.Enrollment;
import com.university.course.model.Student;
import com.university.course.repository.CourseRepository;
import com.university.course.repository.StudentRepository;
import com.university.course.exception.StudentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

//    List<Student> studentlist = new ArrayList<>();
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentException("Student not found with ID: " + id));
    }

    @Override
    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        getStudentById(student.getId());
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Integer id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentException("Student with ID " + id + " does not exist.");
        }

        studentRepository.deleteById(id);
    }

    @Override
    public List<Course> getCoursesForStudent(Integer studentId) {
        Optional<Student> optionalStudent = studentRepository.findWithEnrollmentsById(studentId);

        return optionalStudent.map(student -> student.getEnrollments().stream()
                .map(Enrollment::getCourse)
                .collect(Collectors.toList())
        ).orElse(Collections.emptyList());
    }
}
