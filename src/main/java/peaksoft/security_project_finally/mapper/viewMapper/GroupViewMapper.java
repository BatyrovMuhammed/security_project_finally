package peaksoft.security_project_finally.mapper.viewMapper;

import org.springframework.stereotype.Component;
import peaksoft.security_project_finally.dto.response.GroupResponse;
import peaksoft.security_project_finally.entity.Group;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupViewMapper {

    public GroupResponse viewGroup(Group group) {
        if (group == null) {
            return null;
        }
        GroupResponse groupResponse = new GroupResponse();
        if (group.getId() != null) {
            groupResponse.setId(group.getId());
        }
        groupResponse.setGroupName(group.getGroupName());
        groupResponse.setDateOfStart(group.getDateOfStart());
        groupResponse.setDateOfFinish(group.getDateOfFinish());
        return groupResponse;
    }

    public List<GroupResponse> viewGroups(List<Group> groups) {
        List<GroupResponse> groupResponses = new ArrayList<>();
        for (Group g : groups
        ) {
            groupResponses.add(viewGroup(g));
        }
        return groupResponses;
    }
}
