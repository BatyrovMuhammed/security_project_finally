package peaksoft.security_project_finally.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.security_project_finally.entity.Company;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Override
    List<Company> findAll();

    @Override
    <S extends Company> S save(S entity);

    @Override
    Optional<Company> findById(Long aLong);


    @Override
    Company getById(Long aLong);

    @Override
    void deleteById(Long aLong);
}
