package peaksoft.security_project_finally.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.security_project_finally.dto.request.CourseRequest;
import peaksoft.security_project_finally.dto.response.CourseResponse;
import peaksoft.security_project_finally.entity.Course;
import peaksoft.security_project_finally.service.CompanyService;
import peaksoft.security_project_finally.service.CourseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course/{id}")
@RequiredArgsConstructor
public class CourseApi {

    private final CourseService courseService;
    private final CompanyService companyService;

    @GetMapping
    public List<Course> findAllCourse() {
        return courseService.findAllCourse();
    }

    @PostMapping("/save")
    public CourseResponse saveCourse(@PathVariable("id") Long id,@RequestBody CourseRequest courseRequest) {
        courseRequest.setCompanyId(companyService.getByIdCompany(id));
        return courseService.saveCourse(id,courseRequest);
    }

    @DeleteMapping("/delete/{deleteId}")
    public void deleteByCourse(@PathVariable("deleteId") Long id) {
         courseService.deleteByIdCourse(id);
    }

    @GetMapping("/courseId/{courseId}")
    public Course findByIdCourse(@PathVariable("courseId") Long id) {
        return courseService.findByIdCourse(id);
    }

    @PatchMapping("/update/{updateId}")
    public CourseResponse updateCourse(@PathVariable("updateId") Long id, @RequestBody CourseRequest courseRequest) {
        return courseService.updateCourse(id, courseRequest);
    }
}
