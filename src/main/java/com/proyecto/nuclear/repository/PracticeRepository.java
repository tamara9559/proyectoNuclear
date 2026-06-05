package com.proyecto.nuclear.repository;

import com.proyecto.nuclear.entity.Practice;
import com.proyecto.nuclear.enums.EstadoPractica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PracticeRepository extends JpaRepository<Practice, Long> {

    List<Practice> findByEstudianteIdEstudiante(
            Long estudianteId);

    List<Practice> findByEmpresaIdEmpresa(
            Long empresaId);

    List<Practice> findByEstado(
            EstadoPractica estado);

}