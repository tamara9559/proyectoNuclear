package com.proyecto.nuclear.service.impl;

import com.proyecto.nuclear.entity.Vacancy;

import java.util.List;

public interface VacancyServiceImpl {

    Vacancy createVacancy(Vacancy vacancy);

    Vacancy updateVacancy(Long id, Vacancy vacancy);

    Vacancy findById(Long id);

    List<Vacancy> findAll();

    List<Vacancy> findOpenVacancies();

    List<Vacancy> findByCompany(Long companyId);

    void closeVacancy(Long id);

    void suspendVacancy(Long id);
}
