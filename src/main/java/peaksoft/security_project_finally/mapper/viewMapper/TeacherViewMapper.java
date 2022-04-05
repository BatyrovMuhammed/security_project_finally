package peaksoft.security_project_finally.mapper.viewMapper;

import org.springframework.stereotype.Component;
import peaksoft.security_project_finally.dto.response.TeacherResponse;
import peaksoft.security_project_finally.entity.Teacher;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherViewMapper {

    public TeacherResponse viewTeacher(Teacher teacher) {
        if (teacher == null) {
            return null;
        }
        TeacherResponse teacherResponse = new TeacherResponse();
        if (teacher.getId() != null) {
            teacherResponse.setId(String.valueOf(teacher.getId()));
        }
        teacherResponse.setFirstName(teacher.getFirstName());
        teacherResponse.setEmail(teacher.getEmail());
        teacherResponse.setLastName(teacher.getLastName());
        return teacherResponse;

    }

    public List<TeacherResponse> viewTeacher(List<Teacher> teachers) {
        List<TeacherResponse> teacherResponses = new ArrayList<>();
        for (Teacher c : teachers
        ) {
            teacherResponses.add(viewTeacher(c));
        }
        return teacherResponses;
    }
}
