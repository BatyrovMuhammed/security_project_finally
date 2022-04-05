package peaksoft.security_project_finally.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import peaksoft.security_project_finally.entity.Group;
import peaksoft.security_project_finally.entity.StudyFarmat;

@Getter
@Setter
public class StudentRequest {

    @NotNull
    private String firstName;

    private String email;

    private String lastName;

    private StudyFarmat studyFarmat;

    @JsonIgnore
    private Group groupId;
}
