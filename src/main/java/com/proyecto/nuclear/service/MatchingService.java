package com.proyecto.nuclear.service;

import com.proyecto.nuclear.entity.Application;
import com.proyecto.nuclear.entity.Student;
import com.proyecto.nuclear.entity.Vacancy;

import java.util.List;

public interface MatchingService {

    List<Student> findCompatibleStudents(Long vacancyId);

    List<Vacancy> findCompatibleVacancies(Long studentId);

    Double calculateCompatibility(
            Student student,
            Vacancy vacancy);

    List<Student> rankCandidates(Long vacancyId);

    List<Application> findGraduateApplications(
            Long vacancyId);
}
