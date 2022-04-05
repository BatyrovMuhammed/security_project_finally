package peaksoft.security_project_finally.mapper.editMapper;

import org.springframework.stereotype.Component;
import peaksoft.security_project_finally.dto.request.StudentRequest;
import peaksoft.security_project_finally.entity.Student;
import peaksoft.security_project_finally.repository.GroupRepository;

@Component
public class StudentEditMapper {

    private final GroupRepository groupRepository;

    public StudentEditMapper(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Student create(Long id, StudentRequest studentRequest) {
        if (studentRequest == null) {
            return null;
        }
        Student student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setEmail(studentRequest.getEmail());
        student.setLastName(studentRequest.getLastName());
        student.setStudyFarmat(studentRequest.getStudyFarmat());
        student.setGroup(groupRepository.getById(id));
        return student;
    }

    public void Update(Student student, StudentRequest studentRequest) {
        student.setFirstName(studentRequest.getFirstName());
        student.setEmail(studentRequest.getEmail());
        student.setLastName(studentRequest.getLastName());
        student.setStudyFormat(studentRequest.getStudyFarmat());
    }
}
