package com.proyecto.nuclear.service;

import com.proyecto.nuclear.entity.Application;
import com.proyecto.nuclear.entity.Company;

import java.util.List;

public interface CompanyService {

    Company createCompany(Company company);

    Company updateCompany(Long id, Company company);

    Company findById(Long id);

    List<Company> findAll();

    Company findByNit(String nit);

    void activateCompany(Long id);

    void deactivateCompany(Long id);

    List<Company> searchBySector(String sector);

    List<Application> getReceivedApplications(
            Long companyId);
}
