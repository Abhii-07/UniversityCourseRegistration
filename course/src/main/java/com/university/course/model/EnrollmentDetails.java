package com.university.course.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentDetails {
    private Integer enrollmentId;
    private Integer studentId;
    private String studentName;
    private Integer courseId;
    private String courseName;
    private Date enrollmentDate;
}
