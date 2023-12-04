package com.university.course.service;

import com.university.course.model.Course;
import com.university.course.repository.CourseRepository;
import com.university.course.exception.CourseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Integer id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new CourseException("Course not found with ID: " + id));
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Integer id, Course courseDetails) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseException("Course not found with ID: " + id));

        course.setName(courseDetails.getName());

        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Integer id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseException("Course not found with ID: " + id));

        courseRepository.delete(course);
    }
}


