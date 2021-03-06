package peaksoft.security_project_finally.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.security_project_finally.dto.request.GroupRequest;
import peaksoft.security_project_finally.dto.response.GroupResponse;
import peaksoft.security_project_finally.entity.Course;
import peaksoft.security_project_finally.entity.Group;
import peaksoft.security_project_finally.mapper.editMapper.GroupEditMapper;
import peaksoft.security_project_finally.mapper.viewMapper.GroupViewMapper;
import peaksoft.security_project_finally.repository.CourseRepository;
import peaksoft.security_project_finally.repository.GroupRepository;
import peaksoft.security_project_finally.service.GroupService;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final GroupEditMapper groupEditMapper;
    private final GroupViewMapper groupViewMapper;
    private final CourseRepository courseRepository;

    @Override
    public List<Group> findAllGroup() {
        return groupRepository.findAll();
    }

    @Override
    public GroupResponse saveGroup(Long id, GroupRequest groupRequest) {
        return groupViewMapper.viewGroup(groupRepository.save(groupEditMapper.create(id, groupRequest)));
    }

    @Override
    public Optional<Group> findByIdGroup(Long id) {
        return groupRepository.findById(id);
    }

    @Override
    public Group getByIdGroup(Long id) {
        return groupRepository.getById(id);
    }

    @Override
    public void deleteByIdGroup(Long id) {
        Group group = groupRepository.findById(id).orElseThrow();
        group.getCourses().forEach(u -> u.getGro().remove(group));
        courseRepository.saveAll(group.getCourses());
        groupRepository.delete(group);
    }

    @Override
    public GroupResponse updateGroup(Long id, GroupRequest groupRequest) {
        Group group = groupRepository.findById(id).get();
        groupEditMapper.update(group, groupRequest);
        return groupViewMapper.viewGroup(groupRepository.save(group));
    }
}
