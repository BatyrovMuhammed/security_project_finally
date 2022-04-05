package peaksoft.security_project_finally.dto.response;

import lombok.Getter;
import lombok.Setter;
import peaksoft.security_project_finally.entity.StudyFarmat;

@Getter
@Setter
public class StudentResponse {

    private String id;

    private String firstName;

    private String email;

    private String lastName;

    private StudyFarmat studyFarmat;
}
