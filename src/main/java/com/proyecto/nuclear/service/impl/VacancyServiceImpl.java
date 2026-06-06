package com.proyecto.nuclear.service.impl;

import com.proyecto.nuclear.entity.Application;
import com.proyecto.nuclear.entity.Vacancy;
import com.proyecto.nuclear.enums.EstadoVacante;
import com.proyecto.nuclear.exception.ResourceNotFoundException;
import com.proyecto.nuclear.repository.ApplicationRepository;
import com.proyecto.nuclear.repository.VacancyRepository;
import com.proyecto.nuclear.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {

    private final VacancyRepository vacancyRepository;
    private final ApplicationRepository applicationRepository;

    @Override
    public Vacancy createVacancy(Vacancy vacancy) {
        vacancy.setFechaPublicacion(LocalDateTime.now());
        vacancy.setEstado(EstadoVacante.ABIERTA);
        return vacancyRepository.save(vacancy);
    }

    @Override
    public Vacancy updateVacancy(Long id, Vacancy vacancy) {
        Vacancy existing = findById(id);

        existing.setTitulo(vacancy.getTitulo());
        existing.setDescripcion(vacancy.getDescripcion());
        existing.setHabilidadesRequeridas(vacancy.getHabilidadesRequeridas());
        existing.setModalidad(vacancy.getModalidad());
        existing.setCiudad(vacancy.getCiudad());

        return vacancyRepository.save(existing);
    }

    @Override
    public Vacancy findById(Long id) {
        return vacancyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vacante no encontrada"));
    }

    @Override
    public List<Vacancy> findAll() {
        return vacancyRepository.findAll();
    }

    @Override
    public List<Vacancy> findOpenVacancies() {
        return vacancyRepository.findByEstado(EstadoVacante.ABIERTA);
    }

    @Override
    public List<Vacancy> findByCompany(Long companyId) {
        return vacancyRepository.findByEmpresaId(companyId);
    }

    @Override
    public void closeVacancy(Long id) {
        Vacancy vacancy = findById(id);
        vacancy.setEstado(EstadoVacante.CERRADA);
        vacancyRepository.save(vacancy);
    }

    @Override
    public void suspendVacancy(Long id) {
        Vacancy vacancy = findById(id);
        vacancy.setEstado(EstadoVacante.SUSPENDIDA);
        vacancyRepository.save(vacancy);
    }

    @Override
    public List<Application> getApplications(
            Long vacancyId) {

        return applicationRepository
                .findByVacanteId(vacancyId);
    }
}
