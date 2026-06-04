package com.proyecto.nuclear.service.impl;

import com.proyecto.nuclear.entity.Student;
import com.proyecto.nuclear.entity.Vacancy;

import java.util.List;

public interface MatchingServiceImpl {

    List<Student> findCompatibleStudents(Long vacancyId);

    List<Vacancy> findCompatibleVacancies(Long studentId);

    Double calculateCompatibility(
            Student student,
            Vacancy vacancy);

    List<Student> rankCandidates(Long vacancyId);
}
