# University Course Management System

This project is a University Course Management System designed to handle student enrollment, course management, and related functionalities.

## Table of Contents

- [Setup](#setup)
- [Running the System](#running-the-system)
- [API Endpoints](#api-endpoints)
- [Postman Collection](#postman-collection)
- [Project Structure](#project-structure)

## Setup

To set up the project on your local machine, follow these steps:

1. **Clone the Repository:** Use `git clone` to clone the repository:
   ```bash
   git clone https://github.com/your-username/university-course-management.git
   ```

2. **Install Dependencies:** Navigate to the project directory and install the dependencies:
   ```bash
   cd university-course-management
   cd course
   ```

3. **Database Configuration:** Configure the database settings in `application.properties` or the respective configuration file.

  

## Running the System

To run the system locally, execute the following steps:

1. **Run the Application:** Run the CourseApplication file

2. **Access the Application:** The application should be accessible at `http://localhost:8080` by default.

## API Endpoints

The following are the main API endpoints for this system:

## Course Endpoints
- GET /courses: Retrieve all courses.
- GET /courses/{id}: Retrieve a specific course by ID.
- POST /courses: Create a new course.
- PUT /courses/{id}: Update details of a specific course.
- DELETE /courses/{id}: Delete a course by ID.

## Enrollment Endpoints
- POST /enrollments/enroll: Enroll a student in a course by providing studentId and courseId as parameters.
- GET /enrollments: Retrieve all enrollments with details.
- GET /enrollments/{id}: Retrieve enrollment details by ID.
- PUT /enrollments/{id}: Update enrollment details.
- DELETE /enrollments/{id}: Delete an enrollment by ID.

## Student Endpoints
- GET /students: Retrieve all students.
- GET /students/{id}: Retrieve a specific student by ID.
- POST /students: Register a new student.
- PUT /students/{id}: Update details of a specific student.
- DELETE /students/{id}: Delete a student by ID.
- GET /students/{studentId}/courses: Retrieve courses for a specific student.

## Postman Collection

For detailed requests and examples
[<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" style="width: 128px; height: 32px;">](https://app.getpostman.com/run-collection/20164701-b533ff4f-ed77-44ef-b10b-474b1c4f0a12?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D20164701-b533ff4f-ed77-44ef-b10b-474b1c4f0a12%26entityType%3Dcollection%26workspaceId%3D5d118926-c674-44a8-a082-1f1e58a2730c)

## Project Structure

- `src/` - Contains the source code.
- `docs/` - Documentation related to the project.
