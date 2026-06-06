package com.proyecto.nuclear.service.impl;

import com.proyecto.nuclear.entity.Application;
import com.proyecto.nuclear.entity.Company;
import com.proyecto.nuclear.entity.Vacancy;
import com.proyecto.nuclear.exception.ResourceNotFoundException;
import com.proyecto.nuclear.repository.ApplicationRepository;
import com.proyecto.nuclear.repository.CompanyRepository;
import com.proyecto.nuclear.repository.VacancyRepository;
import com.proyecto.nuclear.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final ApplicationRepository applicationRepository;
    private final VacancyRepository vacancyRepository;

    @Override
    public Company createCompany(Company company) {
        company.setFechaRegistro(LocalDateTime.now());
        company.setEstado(true);
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Long id, Company company) {
        Company existing = findById(id);

        existing.setRazonSocial(company.getRazonSocial());
        existing.setSector(company.getSector());
        existing.setTelefono(company.getTelefono());
        existing.setCiudad(company.getCiudad());
        existing.setDireccion(company.getDireccion());

        return companyRepository.save(existing);
    }

    @Override
    public Company findById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada"));
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findByNit(String nit) {
        return companyRepository.findByNit(nit)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada por NIT"));
    }

    @Override
    public void activateCompany(Long id) {
        Company company = findById(id);
        company.setEstado(true);
        companyRepository.save(company);
    }

    @Override
    public void deactivateCompany(Long id) {
        Company company = findById(id);
        company.setEstado(false);
        companyRepository.save(company);
    }

    @Override
    public List<Company> searchBySector(String sector) {
        return companyRepository.findBySector(sector);
    }

    @Override
    public List<Application> getReceivedApplications(
            Long companyId) {

        List<Vacancy> vacancies =
                vacancyRepository.findByEmpresaId(companyId);

        return vacancies.stream()
                .flatMap(v ->
                        applicationRepository
                                .findByVacanteId(v.getId())
                                .stream())
                .toList();
    }
}
