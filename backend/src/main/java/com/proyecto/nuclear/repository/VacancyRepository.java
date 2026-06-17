package com.proyecto.nuclear.repository;

import com.proyecto.nuclear.entity.Vacancy;
import com.proyecto.nuclear.enums.EstadoVacante;
import com.proyecto.nuclear.enums.TipoVacante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {

    List<Vacancy> findByEmpresaId(Long empresaId);

    List<Vacancy> findByEstado(EstadoVacante estado);

    List<Vacancy> findByTipoVacante(TipoVacante tipoVacante);

    List<Vacancy> findByCarreraRequerida(String carrera);

    List<Vacancy> findByCiudad(String ciudad);

}
