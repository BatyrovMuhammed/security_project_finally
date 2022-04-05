package peaksoft.security_project_finally.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import peaksoft.security_project_finally.entity.Course;

@Getter
@Setter
public class GroupRequest {

    @NotNull
    private String groupName;

    private String dateOfStart;

    private String dateOfFinish;

    @JsonIgnore
    private Course courseId;

}
