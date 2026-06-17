package com.proyecto.nuclear.service.impl;

import com.proyecto.nuclear.DTO.CandidateMatchDTO;
import com.proyecto.nuclear.entity.Application;
import com.proyecto.nuclear.entity.Student;
import com.proyecto.nuclear.entity.Vacancy;
import com.proyecto.nuclear.repository.ApplicationRepository;
import com.proyecto.nuclear.repository.StudentRepository;
import com.proyecto.nuclear.repository.VacancyRepository;
import com.proyecto.nuclear.service.MatchingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
                                vacancy
                        ) >= 60
                )
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
                                vacancy
                        ) >= 60
                )
                .toList();
    }

    @Override
    public Double calculateCompatibility(
            Student student,
            Vacancy vacancy
    ) {

        double score = 0;

        if (
                student.getCarrera() != null
                        &&
                        vacancy.getCarreraRequerida() != null
                        &&
                        areRelatedCareers(
                                student.getCarrera(),
                                vacancy.getCarreraRequerida()
                        )
        ) {

            score += 40;
        }

        if (
                student.getHabilidades() != null
                        &&
                        vacancy.getHabilidadesRequeridas() != null
        ) {

            score += calculateSkillsScore(
                    student.getHabilidades(),
                    vacancy.getHabilidadesRequeridas()
            );
        }

        if (
                student.getCompetencias() != null
                        &&
                        vacancy.getCompetenciasRequeridas() != null
        ) {

            score += calculateCompetenciesScore(
                    student.getCompetencias(),
                    vacancy.getCompetenciasRequeridas()
            );
        }

        return score;
    }

    private boolean areRelatedCareers(
            String studentCareer,
            String vacancyCareer
    ) {

        String student =
                studentCareer.toLowerCase();

        String vacancy =
                vacancyCareer.toLowerCase();

        if (
                student.equals(vacancy)
        ) {

            return true;
        }

        if (
                student.contains("software")
                        &&
                        (
                                vacancy.contains("sistemas")
                                        ||
                                        vacancy.contains("afines")
                        )
        ) {

            return true;
        }

        if(
                student.contains("sistemas")
                        &&
                        (
                                vacancy.contains("software")
                                        ||
                                        vacancy.contains("afines")
                        )
        ) {

            return true;
        }

        return false;
    }

    private double calculateSkillsScore(
            String studentSkills,
            String requiredSkills
    ) {

        List<String> studentList =
                Arrays.stream(
                                studentSkills.split(",")
                        )
                        .map(String::trim)
                        .map(String::toLowerCase)
                        .toList();

        List<String> requiredList =
                Arrays.stream(
                                requiredSkills.split(",")
                        )
                        .map(String::trim)
                        .map(String::toLowerCase)
                        .toList();

        long matches =
                requiredList.stream()
                        .filter(studentList::contains)
                        .count();

        return (
                (double) matches
                        /
                        requiredList.size()
        ) * 40;
    }

    private double calculateCompetenciesScore(
            String studentCompetencies,
            String requiredCompetencies
    ) {

        List<String> studentList =
                Arrays.stream(
                                studentCompetencies.split(",")
                        )
                        .map(String::trim)
                        .map(String::toLowerCase)
                        .toList();

        List<String> requiredList =
                Arrays.stream(
                                requiredCompetencies.split(",")
                        )
                        .map(String::trim)
                        .map(String::toLowerCase)
                        .toList();

        long matches =
                requiredList.stream()
                        .filter(studentList::contains)
                        .count();

        return (
                (double) matches
                        /
                        requiredList.size()
        ) * 20;
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
                                                vacancy
                                        )
                        )
                )
                .toList();
    }

    @Override
    public List<Application> findGraduateApplications(
            Long vacancyId
    ) {

        return applicationRepository
                .findByVacanteId(vacancyId);
    }

    @Override
    public List<CandidateMatchDTO> rankCandidatesWithScore(
            Long vacancyId
    ) {

        Vacancy vacancy =
                vacancyRepository.findById(vacancyId)
                        .orElseThrow();

        return studentRepository.findAll()
                .stream()
                .map(student ->

                        CandidateMatchDTO.builder()

                                .studentId(
                                        student.getId()
                                )

                                .nombre(
                                        student.getUsuario()
                                                .getNombres()
                                                + " "
                                                +
                                                student.getUsuario()
                                                        .getApellidos()
                                )

                                .carrera(
                                        student.getCarrera()
                                )

                                .compatibility(
                                        calculateCompatibility(
                                                student,
                                                vacancy
                                        )
                                )

                                .build()

                )

                .sorted(
                        Comparator.comparingDouble(
                                        CandidateMatchDTO::getCompatibility
                                )
                                .reversed()
                )

                .toList();
    }

}