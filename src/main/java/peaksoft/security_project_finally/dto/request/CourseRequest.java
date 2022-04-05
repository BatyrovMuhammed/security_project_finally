package peaksoft.security_project_finally.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import peaksoft.security_project_finally.entity.Company;

import javax.persistence.Transient;

@Getter
@Setter
public class CourseRequest {

    @NotNull
    private String courseName;

    private String duration;

    @JsonIgnore
    private Company companyId;
}
