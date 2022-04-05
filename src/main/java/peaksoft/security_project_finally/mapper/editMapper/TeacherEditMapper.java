package peaksoft.security_project_finally.mapper.editMapper;

import org.springframework.stereotype.Component;
import peaksoft.security_project_finally.dto.request.TeacherRequest;
import peaksoft.security_project_finally.entity.Teacher;
import peaksoft.security_project_finally.repository.CourseRepository;

@Component
public class TeacherEditMapper {

    private final CourseRepository courseRepository;

    public TeacherEditMapper(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Teacher create(Long id, TeacherRequest teacherRequest) {
        if (teacherRequest == null) {
            return null;
        }
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherRequest.getFirstName());
        teacher.setEmail(teacherRequest.getEmail());
        teacher.setLastName(teacherRequest.getLastName());
        teacher.setCourse(courseRepository.getById(id));
        return teacher;
    }

    public void Update(Teacher teacher, TeacherRequest teacherRequest) {
        teacher.setFirstName(teacherRequest.getFirstName());
        teacher.setEmail(teacherRequest.getEmail());
        teacher.setLastName(teacherRequest.getLastName());
    }

}
