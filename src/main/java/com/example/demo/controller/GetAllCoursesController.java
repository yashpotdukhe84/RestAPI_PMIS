package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class GetAllCoursesController {

    private final CourseService courseService;

    public GetAllCoursesController(CourseService courseService) {
        this.courseService = courseService;
    }

    // Get all courses
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {

        List<Course> courses = courseService.getAllCourses();

        return ResponseEntity.ok(courses);
    }
}