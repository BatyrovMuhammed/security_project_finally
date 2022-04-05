package peaksoft.security_project_finally.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.security_project_finally.dto.request.TeacherRequest;
import peaksoft.security_project_finally.dto.response.TeacherResponse;
import peaksoft.security_project_finally.entity.Teacher;
import peaksoft.security_project_finally.service.CourseService;
import peaksoft.security_project_finally.service.TeacherService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teacher/{id}")
@RequiredArgsConstructor
public class TeacherApi {

    private final TeacherService teacherService;
    private final CourseService courseService;

    @GetMapping
    public List<Teacher> findAllTeacher() {
        return teacherService.findAllTeacher();
    }

    @PostMapping("/save")
    public TeacherResponse saveTeacher(@RequestBody TeacherRequest teacherRequest, @PathVariable("id") Long id) throws Exception {
        if (courseService.getByIdCourse(id).getTeacher() == null) {
            teacherRequest.setCourse(courseService.getByIdCourse(id));
        } else {
            throw new Exception();
        }
        return teacherService.saveTeacher(id, teacherRequest);
    }

    @DeleteMapping("/delete/{deleteId}")
    public void deleteByTeacher(@PathVariable("deleteId") Long id) {
        teacherService.deleteByIdTeacher(id);
    }

    @GetMapping("/find/{findId}")
    public Optional<Teacher> findByIdTeacher(@PathVariable("findId") Long id) {
        return teacherService.findByIdTeacher(id);
    }

    @PatchMapping("/update/{updateId}")
    public TeacherResponse updateCourse(@PathVariable("updateId") Long id, @RequestBody TeacherRequest teacherRequest) {
        return teacherService.updateTeacher(id, teacherRequest);
    }
}
