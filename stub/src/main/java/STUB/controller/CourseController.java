package STUB.controller;

import STUB.dao.Course;
import STUB.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/get/{id}")
    public Course getCourseById(@PathVariable long id) {
        return courseRepository.getById(id);
    }

    @GetMapping("/get/all")
    public List<Course> getAllUser() {
        return courseRepository.getAllCourses();
    }

}
