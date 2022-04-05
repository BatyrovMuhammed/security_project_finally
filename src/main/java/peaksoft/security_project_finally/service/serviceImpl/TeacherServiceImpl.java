package peaksoft.security_project_finally.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.security_project_finally.dto.request.TeacherRequest;
import peaksoft.security_project_finally.dto.response.TeacherResponse;
import peaksoft.security_project_finally.entity.Teacher;
import peaksoft.security_project_finally.mapper.editMapper.TeacherEditMapper;
import peaksoft.security_project_finally.mapper.viewMapper.TeacherViewMapper;
import peaksoft.security_project_finally.repository.TeacherRepository;
import peaksoft.security_project_finally.service.TeacherService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherEditMapper teacherEditMapper;
    private final TeacherViewMapper teacherViewMapper;

    @Override
    public List<Teacher> findAllTeacher() {
        return teacherRepository.findAll();
    }

    @Override
    public TeacherResponse saveTeacher(Long id, TeacherRequest teacherRequest) {
        return teacherViewMapper.viewTeacher(teacherRepository.save(teacherEditMapper.create(id, teacherRequest)));
    }

    @Override
    public Optional<Teacher> findByIdTeacher(Long id) {
        return teacherRepository.findById(id);
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepository.getById(id);
    }

    @Override
    public void deleteByIdTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public TeacherResponse updateTeacher(Long id, TeacherRequest teacherRequest) {
        Teacher teacher = teacherRepository.findById(id).get();
        teacherEditMapper.Update(teacher, teacherRequest);
        return teacherViewMapper.viewTeacher(teacherRepository.save(teacher));
    }
}
