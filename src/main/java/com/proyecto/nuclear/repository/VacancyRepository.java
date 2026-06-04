package com.proyecto.nuclear.repository;


import com.proyecto.nuclear.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
}
