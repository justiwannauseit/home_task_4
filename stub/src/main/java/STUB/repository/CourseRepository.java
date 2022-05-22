package STUB.repository;

import STUB.dao.Course;
import STUB.repository.crudInterface.CourseRepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class CourseRepository {

    @Autowired
    private CourseRepositoryCrud courseRepositoryCrud;


    public Course getById(final long id) {
        return courseRepositoryCrud.findById(id).get();
    }

    public List<Course> getAllCourses() {
        return StreamSupport.stream(courseRepositoryCrud.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

}
