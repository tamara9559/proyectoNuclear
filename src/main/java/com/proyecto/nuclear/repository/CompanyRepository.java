package com.proyecto.nuclear.repository;


import com.proyecto.nuclear.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}