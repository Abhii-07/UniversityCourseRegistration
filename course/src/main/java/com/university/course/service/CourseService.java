package com.university.course.service;

import com.university.course.model.Course;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CourseService {
    List<Course> getAllCourses();
    Course getCourseById(Integer id);

    Course createCourse(Course course);

    Course updateCourse(Integer id, Course courseDetails);

    void deleteCourse(Integer id);
}
