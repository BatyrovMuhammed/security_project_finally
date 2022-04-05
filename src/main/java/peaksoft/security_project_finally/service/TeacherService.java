package peaksoft.security_project_finally.service;

import peaksoft.security_project_finally.dto.request.TeacherRequest;
import peaksoft.security_project_finally.dto.response.TeacherResponse;
import peaksoft.security_project_finally.entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    List<Teacher> findAllTeacher();

    TeacherResponse saveTeacher(Long id, TeacherRequest teacherRequest);

    Optional<Teacher> findByIdTeacher(Long id);

    Teacher getTeacherById(Long id);

    void deleteByIdTeacher(Long id);

    TeacherResponse updateTeacher(Long id, TeacherRequest teacherRequest);
}
