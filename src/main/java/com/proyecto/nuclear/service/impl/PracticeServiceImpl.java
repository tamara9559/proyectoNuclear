package com.proyecto.nuclear.service.impl;

import com.proyecto.nuclear.entity.Practice;
import com.proyecto.nuclear.enums.EstadoPractica;
import com.proyecto.nuclear.exception.ResourceNotFoundException;
import com.proyecto.nuclear.repository.PracticeRepository;
import com.proyecto.nuclear.service.PracticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PracticeServiceImpl implements PracticeService {

    private final PracticeRepository practiceRepository;

    @Override
    public Practice createPractice(Practice practice) {
        practice.setEstado(EstadoPractica.PENDIENTE);
        return practiceRepository.save(practice);
    }

    @Override
    public Practice updatePractice(Long id, Practice practice) {

        Practice existing = findById(id);

        existing.setCiudad(practice.getCiudad());
        existing.setTutorEmpresarial(practice.getTutorEmpresarial());
        existing.setCorreoTutor(practice.getCorreoTutor());
        existing.setTipoContrato(practice.getTipoContrato());
        existing.setFechaInicio(practice.getFechaInicio());
        existing.setFechaFin(practice.getFechaFin());
        existing.setObservaciones(practice.getObservaciones());

        return practiceRepository.save(existing);
    }

    @Override
    public Practice findById(Long id) {
        return practiceRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Práctica no encontrada: " + id));
    }

    @Override
    public List<Practice> findAll() {
        return practiceRepository.findAll();
    }

    @Override
    public void cancelPractice(Long practiceId, String reason) {

        Practice practice = findById(practiceId);

        practice.setEstado(EstadoPractica.CANCELADA);
        practice.setObservaciones(reason);

        practiceRepository.save(practice);
    }

    @Override
    public void registerMobilityRequest(Long practiceId) {

        Practice practice = findById(practiceId);

        practice.setRequiereMovilidad(true);

        practiceRepository.save(practice);
    }

    @Override
    public void startPractice(Long practiceId) {

        Practice practice = findById(practiceId);

        practice.setEstado(EstadoPractica.ACTIVA);

        practiceRepository.save(practice);
    }

    @Override
    public void finishPractice(Long practiceId) {

        Practice practice = findById(practiceId);

        practice.setEstado(EstadoPractica.FINALIZADA);

        practiceRepository.save(practice);
    }

    @Override
    public Long calculateDurationWeeks(Long practiceId) {

        Practice practice = findById(practiceId);

        if (practice.getFechaInicio() == null ||
                practice.getFechaFin() == null) {
            return 0L;
        }

        return ChronoUnit.WEEKS.between(
                practice.getFechaInicio(),
                practice.getFechaFin()
        );
    }
}