package com.sliit.gpa.controller;

import com.sliit.gpa.model.Course;
import com.sliit.gpa.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "*")
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping
    public List<Course> getAllCourses() {
        return service.getCourses();
    }

    @PostMapping
    public void addOrUpdateCourse(@RequestBody Course course) {
        service.saveCourse(course);
    }

    @DeleteMapping("/{name}")
    public void deleteCourse(@PathVariable String name) {
        service.deleteCourse(name);
    }

    @GetMapping("/gpa")
    public double getGpa() {
        return service.calculateGPA();
    }

    @DeleteMapping("/clear")
    public void clearAll() {
        service.clearAll();
    }
}
