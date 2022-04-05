package peaksoft.security_project_finally.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import peaksoft.security_project_finally.entity.Course;

@Getter
@Setter
public class TeacherRequest {

    @NotNull
    private String firstName;

    private String email;

    private String lastName;

    @JsonIgnore
    private Course course;
}
