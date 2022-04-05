package peaksoft.security_project_finally.service;

import peaksoft.security_project_finally.dto.request.CourseRequest;
import peaksoft.security_project_finally.dto.response.CourseResponse;
import peaksoft.security_project_finally.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> findAllCourse();

    CourseResponse saveCourse(Long id, CourseRequest courseRequest);

    CourseResponse updateCourse(Long id, CourseRequest courseRequest);

    Course findByIdCourse(Long id);

    Course getByIdCourse(Long id);

    void deleteByIdCourse(Long id);
}
