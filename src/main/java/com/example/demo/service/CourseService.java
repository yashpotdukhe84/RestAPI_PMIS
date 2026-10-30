package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    // Constructor injection
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Create course
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    // Get all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Get course by ID
    public Course getCourseById(Long courseId) {
        return courseRepository.findById(courseId);
    }

    // Update course
    public Course updateCourse(Long courseId, Course courseDetails) {

        Course existingCourse = courseRepository.findById(courseId);

        if (existingCourse == null) {
            return null;
        }

        existingCourse.setTitle(courseDetails.getTitle());
        existingCourse.setDescription(courseDetails.getDescription());

        return courseRepository.save(existingCourse);
    }

    // Delete course
    public boolean deleteCourse(Long courseId) {

        Course existingCourse = courseRepository.findById(courseId);

        if (existingCourse == null) {
            return false;
        }

        courseRepository.deleteById(courseId);

        return true;
    }
}