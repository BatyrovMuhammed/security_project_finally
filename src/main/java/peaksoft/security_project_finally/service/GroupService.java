package peaksoft.security_project_finally.service;

import peaksoft.security_project_finally.dto.request.GroupRequest;
import peaksoft.security_project_finally.dto.response.GroupResponse;
import peaksoft.security_project_finally.entity.Group;

import java.util.List;
import java.util.Optional;

public interface GroupService {

    List<Group> findAllGroup();

    GroupResponse saveGroup(Long id, GroupRequest groupRequest);

    Optional<Group> findByIdGroup(Long id);

    Group getByIdGroup(Long id);

    void deleteByIdGroup(Long id);

    GroupResponse updateGroup(Long id, GroupRequest groupRequest);
}
