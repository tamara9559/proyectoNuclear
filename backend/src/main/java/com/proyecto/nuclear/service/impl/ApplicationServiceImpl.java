package com.proyecto.nuclear.service.impl;

import com.proyecto.nuclear.entity.Application;
import com.proyecto.nuclear.entity.User;
import com.proyecto.nuclear.entity.Vacancy;
import com.proyecto.nuclear.enums.EstadoApplication;
import com.proyecto.nuclear.enums.RolUsuario;
import com.proyecto.nuclear.exception.ResourceNotFoundException;
import com.proyecto.nuclear.repository.ApplicationRepository;
import com.proyecto.nuclear.repository.UserRepository;
import com.proyecto.nuclear.repository.VacancyRepository;
import com.proyecto.nuclear.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl
        implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    private final UserRepository userRepository;

    private final VacancyRepository vacancyRepository;

    @Override
    public Application apply(
            Long userId,
            Long vacancyId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Usuario no encontrado"));

        Vacancy vacancy = vacancyRepository.findById(vacancyId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Vacante no encontrada"));

        if (!user.getRol().equals(RolUsuario.EGRESADO)) {
            throw new RuntimeException(
                    "Solo los egresados pueden postularse");
        }

        if (applicationRepository
                .existsByUsuarioIdAndVacanteId(
                        userId,
                        vacancyId)) {

            throw new RuntimeException(
                    "Ya existe una postulación para esta vacante");
        }

        Application application =
                Application.builder()
                        .usuario(user)
                        .vacante(vacancy)
                        .estado(EstadoApplication.ENVIADA)
                        .fechaPostulacion(LocalDateTime.now())
                        .build();

        return applicationRepository.save(application);
    }

    @Override
    public Application findById(
            Long applicationId) {

        return applicationRepository.findById(applicationId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Postulación no encontrada"));
    }

    @Override
    public List<Application> findAll() {
        return applicationRepository.findAll();
    }

    @Override
    public List<Application> findByUser(
            Long userId) {

        return applicationRepository
                .findByUsuarioId(userId);
    }

    @Override
    public List<Application> findByVacancy(
            Long vacancyId) {

        return applicationRepository
                .findByVacanteId(vacancyId);
    }

    @Override
    public void acceptApplication(
            Long applicationId) {

        Application application =
                findById(applicationId);

        application.setEstado(
                EstadoApplication.ACEPTADO);

        applicationRepository.save(application);
    }

    @Override
    public void rejectApplication(
            Long applicationId) {

        Application application =
                findById(applicationId);

        application.setEstado(
                EstadoApplication.RECHAZADO);

        applicationRepository.save(application);
    }

    @Override
    public void withdrawApplication(
            Long applicationId) {

        Application application =
                findById(applicationId);

        applicationRepository.delete(application);
    }

}