package peaksoft.security_project_finally.mapper.editMapper;

import org.springframework.stereotype.Component;
import peaksoft.security_project_finally.dto.request.CourseRequest;
import peaksoft.security_project_finally.entity.Course;
import peaksoft.security_project_finally.repository.CompanyRepository;

@Component
public class CourseEditMapper {

    private final CompanyRepository companyRepository;

    public CourseEditMapper(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Course create(Long id, CourseRequest courseRequest) {
        if (courseRequest == null) {
            return null;
        }
        Course course = new Course();
        course.setCourseName(courseRequest.getCourseName());
        course.setDuration(courseRequest.getDuration());
        course.setCompany(companyRepository.findById(id).get());
        return course;
    }

    public void Update(Course course, CourseRequest courseRequest) {
        course.setCourseName(courseRequest.getCourseName());
        course.setDuration(courseRequest.getDuration());
    }
}
