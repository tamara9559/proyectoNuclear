package com.proyecto.nuclear.service.impl;

import com.proyecto.nuclear.entity.Monitoring;
import com.proyecto.nuclear.enums.TipoSeguimiento;
import com.proyecto.nuclear.repository.MonitoringRepository;
import com.proyecto.nuclear.service.MonitoringService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MonitoringServiceImpl implements MonitoringService {

    private final MonitoringRepository monitoringRepository;

    @Override
    public Monitoring registerVisit(Monitoring monitoring) {

        monitoring.setTipoSeguimiento(
                TipoSeguimiento.VISITA);

        monitoring.setFechaRegistro(
                LocalDateTime.now());

        return monitoringRepository.save(monitoring);
    }

    @Override
    public Monitoring registerObservation(Monitoring monitoring) {

        monitoring.setTipoSeguimiento(
                TipoSeguimiento.OBSERVACION);

        monitoring.setFechaRegistro(
                LocalDateTime.now());

        return monitoringRepository.save(monitoring);
    }

    @Override
    public Monitoring registerMeeting(Monitoring monitoring) {

        monitoring.setTipoSeguimiento(
                TipoSeguimiento.REUNION);

        monitoring.setFechaRegistro(
                LocalDateTime.now());

        return monitoringRepository.save(monitoring);
    }

    @Override
    public Monitoring registerCall(Monitoring monitoring) {

        monitoring.setTipoSeguimiento(
                TipoSeguimiento.LLAMADA);

        monitoring.setFechaRegistro(
                LocalDateTime.now());

        return monitoringRepository.save(monitoring);
    }

    @Override
    public List<Monitoring> findByPractice(Long practiceId) {

        return monitoringRepository
                .findByPracticaId(practiceId);
    }

    @Override
    public List<Monitoring> findByCoordinator(Long coordinatorId) {

        return monitoringRepository
                .findByCoordinadorId(coordinatorId);
    }

    @Override
    public List<Monitoring> getPracticeHistory(Long practiceId) {

        return monitoringRepository
                .findByPracticaId(practiceId);
    }
}