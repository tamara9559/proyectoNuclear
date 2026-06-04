package com.proyecto.nuclear.service.impl;

import com.proyecto.nuclear.entity.Company;

import java.util.List;

public interface CompanyServiceImpl {

    Company createCompany(Company company);

    Company updateCompany(Long id, Company company);

    Company findById(Long id);

    List<Company> findAll();

    Company findByNit(String nit);

    void activateCompany(Long id);

    void deactivateCompany(Long id);

    List<Company> searchBySector(String sector);
}
