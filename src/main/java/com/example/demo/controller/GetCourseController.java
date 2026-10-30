package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class GetCourseController {

    private final CourseService courseService;

    public GetCourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // Get course by ID
    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourseById(
            @PathVariable Long courseId) {

        Course course = courseService.getCourseById(courseId);

        if (course == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(course);
    }
}