package peaksoft.security_project_finally.dto.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyRequest {

    @NotNull
    private String companyName;

    private String locatedCountry;
}
