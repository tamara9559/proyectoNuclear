package com.proyecto.nuclear.repository;


import com.proyecto.nuclear.entity.Monitoring;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitoringRepository extends JpaRepository<Monitoring, Long> {
}
