package com.proyecto.nuclear.repository;

import com.proyecto.nuclear.entity.Application;
import com.proyecto.nuclear.enums.EstadoApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository
        extends JpaRepository<Application, Long> {

    List<Application> findByUsuarioId(
            Long usuarioId);

    List<Application> findByVacanteId(
            Long vacanteId);

    List<Application> findByEstado(
            EstadoApplication estado);

    boolean existsByUsuarioIdAndVacanteId(
            Long usuarioId,
            Long vacanteId);

}
