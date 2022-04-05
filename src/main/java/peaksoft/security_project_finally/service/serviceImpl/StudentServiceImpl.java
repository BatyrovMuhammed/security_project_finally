package peaksoft.security_project_finally.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.security_project_finally.dto.request.StudentRequest;
import peaksoft.security_project_finally.dto.response.StudentResponse;
import peaksoft.security_project_finally.entity.Student;
import peaksoft.security_project_finally.mapper.editMapper.StudentEditMapper;
import peaksoft.security_project_finally.mapper.viewMapper.StudentViewMapper;
import peaksoft.security_project_finally.repository.StudentRepository;
import peaksoft.security_project_finally.service.StudentService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentEditMapper studentEditMapper;
    private final StudentViewMapper studentViewMapper;

    @Override
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public StudentResponse saveStudent(Long id, StudentRequest studentRequest) {
        return studentViewMapper.viewStudent(studentRepository.save(studentEditMapper.create(id, studentRequest)));
    }

    @Override
    public Optional<Student> findByIdStudent(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.getById(id);
    }

    @Override
    public void deleteByIdStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentResponse updateStudent(Long id, StudentRequest studentRequest) {
        Student student = studentRepository.findById(id).get();
        studentEditMapper.Update(student, studentRequest);
        return studentViewMapper.viewStudent(studentRepository.save(student));
    }
}
