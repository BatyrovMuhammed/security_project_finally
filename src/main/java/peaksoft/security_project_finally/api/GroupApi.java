package peaksoft.security_project_finally.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.security_project_finally.dto.request.GroupRequest;
import peaksoft.security_project_finally.dto.response.GroupResponse;
import peaksoft.security_project_finally.entity.Group;
import peaksoft.security_project_finally.service.CourseService;
import peaksoft.security_project_finally.service.GroupService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/group/{id}")
@RequiredArgsConstructor
public class GroupApi {

    private final GroupService groupService;
    private final CourseService courseService;

    @GetMapping
    public List<Group> findAllGroup() {
        return groupService.findAllGroup();
    }

    @PostMapping("/save")
    public GroupResponse saveGroup(@RequestBody GroupRequest groupRequest, @PathVariable("id") Long id) {
        groupRequest.setCourseId(courseService.getByIdCourse(id));
        return groupService.saveGroup(id, groupRequest);
    }

    @DeleteMapping("/delete/{deleteId}")
    public void deleteByGroup(@PathVariable("deleteId") Long id) {
        groupService.deleteByIdGroup(id);
    }

    @GetMapping("/find/{findId}")
    public Optional<Group> findByIdGroup(@PathVariable("findId") Long id) {
        return groupService.findByIdGroup(id);
    }

    @PatchMapping("/updateGroup/{updateId}")
    public GroupResponse updateGroup(@RequestBody GroupRequest groupRequest, @PathVariable("updateId") Long id) {
        return groupService.updateGroup(id, groupRequest);
    }

}
