package com.proyecto.nuclear.repository;

import com.proyecto.nuclear.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByNit(String nit);

    boolean existsByNit(String nit);

    List<Company> findBySector(String sector);

    List<Company> findByCiudad(String ciudad);

}