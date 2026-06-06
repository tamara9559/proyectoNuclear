package com.proyecto.nuclear.service.impl;

import com.proyecto.nuclear.entity.Application;
import com.proyecto.nuclear.entity.Student;
import com.proyecto.nuclear.entity.Vacancy;
import com.proyecto.nuclear.repository.ApplicationRepository;
import com.proyecto.nuclear.repository.StudentRepository;
import com.proyecto.nuclear.repository.VacancyRepository;
import com.proyecto.nuclear.service.MatchingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchingServiceImpl implements MatchingService {

    private final StudentRepository studentRepository;
    private final VacancyRepository vacancyRepository;
    private final ApplicationRepository applicationRepository;

    @Override
    public List<Student> findCompatibleStudents(Long vacancyId) {

        Vacancy vacancy = vacancyRepository.findById(vacancyId)
                .orElseThrow();

        return studentRepository.findAll()
                .stream()
                .filter(student ->
                        calculateCompatibility(
                                student,
                                vacancy) > 40)
                .toList();
    }

    @Override
    public List<Vacancy> findCompatibleVacancies(Long studentId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow();

        return vacancyRepository.findAll()
                .stream()
                .filter(vacancy ->
                        calculateCompatibility(
                                student,
                                vacancy) > 40)
                .toList();
    }

    @Override
    public Double calculateCompatibility(
            Student student,
            Vacancy vacancy) {

        double score = 0;

        if (student.getCarrera() != null &&
                vacancy.getCarreraRequerida() != null &&
                student.getCarrera()
                        .equalsIgnoreCase(
                                vacancy.getCarreraRequerida())) {

            score += 50;
        }

        if (student.getHabilidades() != null &&
                vacancy.getHabilidadesRequeridas() != null &&
                student.getHabilidades()
                        .toLowerCase()
                        .contains(
                                vacancy.getHabilidadesRequeridas()
                                        .toLowerCase())) {

            score += 30;
        }

        if (student.getCompetencias() != null) {
            score += 20;
        }

        return score;
    }

    @Override
    public List<Student> rankCandidates(Long vacancyId) {

        Vacancy vacancy = vacancyRepository.findById(vacancyId)
                .orElseThrow();

        return studentRepository.findAll()
                .stream()
                .sorted(
                        Comparator.comparingDouble(
                                student ->
                                        -calculateCompatibility(
                                                student,
                                                vacancy)))
                .toList();
    }

    @Override
    public List<Application> findGraduateApplications(
            Long vacancyId) {

        return applicationRepository
                .findByVacanteId(vacancyId);
    }
}