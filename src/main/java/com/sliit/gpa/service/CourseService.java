package com.sliit.gpa.service;

import com.sliit.gpa.model.Course;
import com.sliit.gpa.repository.CourseRepository;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseService {
    private CourseRepository repo = new CourseRepository();

    private static final Map<String, Double> gradeToGpa;

    static {
        gradeToGpa = new HashMap<>();
        gradeToGpa.put("A+", 4.0);
        gradeToGpa.put("A", 4.0);
        gradeToGpa.put("A-", 3.7);
        gradeToGpa.put("B+", 3.3);
        gradeToGpa.put("B", 3.0);
        gradeToGpa.put("B-", 2.7);
        gradeToGpa.put("C+", 2.3);
        gradeToGpa.put("C", 2.0);
        gradeToGpa.put("C-", 1.7);
        gradeToGpa.put("D+", 1.3);
        gradeToGpa.put("D", 1.0);
        gradeToGpa.put("E", 0.0);
    }

    public List<Course> getCourses() {
        return repo.getAll();
    }

    public void saveCourse(Course course) {
        repo.save(course);
    }

    public void deleteCourse(String name) {
        repo.delete(name);
    }

    public double calculateGPA() {
        List<Course> list = repo.getAll();
        double total = 0;
        for (Course c : list) {
            total += gradeToGpa.getOrDefault(c.getGrade(), 0.0) * 4;
        }
        return list.isEmpty() ? 0.0 : total / (list.size() * 4);
    }

    public void clearAll() {
        repo.clear();
    }
}
