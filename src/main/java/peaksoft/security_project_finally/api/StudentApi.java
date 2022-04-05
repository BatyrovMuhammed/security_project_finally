package peaksoft.security_project_finally.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.security_project_finally.dto.request.StudentRequest;
import peaksoft.security_project_finally.dto.response.StudentResponse;
import peaksoft.security_project_finally.entity.Student;
import peaksoft.security_project_finally.service.GroupService;
import peaksoft.security_project_finally.service.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student/{id}")
public class StudentApi {

    private final StudentService studentService;
    private final GroupService groupService;

    @GetMapping
    public List<Student> findAllStudent() {
        return studentService.findAllStudent();
    }

    @PostMapping("/save")
    public StudentResponse saveStudent(@PathVariable("id") Long id, @RequestBody StudentRequest studentRequest) {
        studentRequest.setGroupId(groupService.getByIdGroup(id));
        return studentService.saveStudent(id, studentRequest);
    }

    @DeleteMapping("/delete/{deleteId}")
    public void deleteByStudent(@PathVariable("deleteId") Long id) {
        studentService.deleteByIdStudent(id);
    }

    @GetMapping("/find/{findId}")
    public Optional<Student> findByIdStudent(@PathVariable("findId") Long id) {
        return studentService.findByIdStudent(id);
    }

    @PatchMapping("/update/{updateId}")
    public StudentResponse updateCourse(@PathVariable("updateId") Long id, @RequestBody StudentRequest studentRequest) {
        return studentService.updateStudent(id, studentRequest);
    }

}
