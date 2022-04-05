package peaksoft.security_project_finally.service;

import peaksoft.security_project_finally.dto.request.StudentRequest;
import peaksoft.security_project_finally.dto.response.StudentResponse;
import peaksoft.security_project_finally.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> findAllStudent();

    StudentResponse saveStudent(Long id, StudentRequest studentRequest);

    Optional<Student> findByIdStudent(Long id);

    Student getStudentById(Long id);

    void deleteByIdStudent(Long id);

    StudentResponse updateStudent(Long id, StudentRequest studentRequest);
}
