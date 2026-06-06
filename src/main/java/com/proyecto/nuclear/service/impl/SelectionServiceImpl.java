package com.proyecto.nuclear.service.impl;

import com.proyecto.nuclear.entity.Application;
import com.proyecto.nuclear.entity.Student;
import com.proyecto.nuclear.enums.EstadoApplication;
import com.proyecto.nuclear.enums.EstadoPracticaEstudiante;
import com.proyecto.nuclear.exception.ResourceNotFoundException;
import com.proyecto.nuclear.repository.ApplicationRepository;
import com.proyecto.nuclear.repository.StudentRepository;
import com.proyecto.nuclear.repository.VacancyRepository;
import com.proyecto.nuclear.service.SelectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SelectionServiceImpl implements SelectionService {

    private final StudentRepository studentRepository;
    private final VacancyRepository vacancyRepository;
    private final ApplicationRepository applicationRepository;

    @Override
    public void sendResumeToCompany(
            Long studentId,
            Long vacancyId) {

        Student student =
                studentRepository.findById(studentId)
                        .orElseThrow();

        student.setEstadoPractica(
                EstadoPracticaEstudiante.EN_PROCESO);

        studentRepository.save(student);
    }

    @Override
    public void acceptCandidate(
            Long studentId,
            Long vacancyId) {

        Student student =
                studentRepository.findById(studentId)
                        .orElseThrow();

        student.setEstadoPractica(
                EstadoPracticaEstudiante.ASIGNADO);

        studentRepository.save(student);
    }

    @Override
    public void rejectCandidate(
            Long studentId,
            Long vacancyId) {

        Student student =
                studentRepository.findById(studentId)
                        .orElseThrow();

        student.setEstadoPractica(
                EstadoPracticaEstudiante.SIN_ASIGNAR);

        studentRepository.save(student);
    }

    @Override
    public void finalizeAssignment(
            Long studentId,
            Long vacancyId) {

        Student student =
                studentRepository.findById(studentId)
                        .orElseThrow();

        student.setEstadoPractica(
                EstadoPracticaEstudiante.EN_PRACTICA);

        studentRepository.save(student);
    }

    @Override
    public void updateSelectionStatus(
            Long studentId,
            Long vacancyId,
            String status) {

        Student student =
                studentRepository.findById(studentId)
                        .orElseThrow();

        student.setDisponibilidad(status);

        studentRepository.save(student);
    }

    @Override
    public void acceptApplication(Long applicationId) {

        Application application =
                applicationRepository.findById(applicationId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Postulación no encontrada"));

        application.setEstado(
                EstadoApplication.EN_REVISION);

        applicationRepository.save(application);
    }

    @Override
    public void rejectApplication(Long applicationId) {

        Application application =
                applicationRepository.findById(applicationId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Postulación no encontrada"));

        application.setEstado(
                EstadoApplication.RECHAZADO);

        applicationRepository.save(application);
    }

    @Override
    public void hireGraduate(Long applicationId) {

        Application application =
                applicationRepository.findById(applicationId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Postulación no encontrada"));

        application.setEstado(
                EstadoApplication.CONTRATADO);

        applicationRepository.save(application);
    }
}