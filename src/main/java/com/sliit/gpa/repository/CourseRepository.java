package com.sliit.gpa.repository;

import com.sliit.gpa.model.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    private static List<Course> courses = new ArrayList<>();

    public List<Course> getAll() {
        return courses;
    }

    public void save(Course course) {
        courses.removeIf(c -> c.getCourseName().equals(course.getCourseName()));
        courses.add(course);
    }

    public void delete(String courseName) {
        courses.removeIf(c -> c.getCourseName().equals(courseName));
    }

    public void clear() {
        courses.clear();
    }
}
