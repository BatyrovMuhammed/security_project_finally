package peaksoft.security_project_finally.api;

//Guava salyshtyruu dependency;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.security_project_finally.dto.request.CompanyRequest;
import peaksoft.security_project_finally.dto.response.CompanyResponse;
import peaksoft.security_project_finally.entity.Company;
import peaksoft.security_project_finally.service.CompanyService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class CompanyApi {

    private final CompanyService companyService;

    @GetMapping
    public List<Company> findAllCompany() {
        return companyService.findAllCompany();
    }

    @PostMapping("/save/company")
    public CompanyResponse save(@RequestBody CompanyRequest companyRequest) {
        return companyService.saveCompany(companyRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteByCompany(@PathVariable Long id) {
         companyService.deleteByIdCompany(id);
    }

    @GetMapping("/find/{id}")
    public Optional<Company> findByIdCompany(@PathVariable("id") Long id) {
        return companyService.findByIdCompany(id);
    }

    @PatchMapping("/update/{id}")
    public CompanyResponse updateCompany(@PathVariable("id") Long id, @RequestBody CompanyRequest companyRequest) {
        return companyService.updateCompany(id, companyRequest);
    }

}
