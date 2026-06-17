package com.proyecto.nuclear.repository;

import com.proyecto.nuclear.entity.Monitoring;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MonitoringRepository extends JpaRepository<Monitoring, Long> {

    List<Monitoring> findByPracticaId(
            Long practicaId);

    List<Monitoring> findByCoordinadorId(
            Long coordinadorId);

}
