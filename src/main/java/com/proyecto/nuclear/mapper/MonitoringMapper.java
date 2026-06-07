package com.proyecto.nuclear.mapper;

import com.proyecto.nuclear.DTO.MonitoringDTO;
import com.proyecto.nuclear.entity.*;

public class MonitoringMapper {

    public static MonitoringDTO toDTO(Monitoring monitoring) {

        if (monitoring == null) {
            return null;
        }

        return MonitoringDTO.builder()
                .id(monitoring.getId())
                .practicaId(monitoring.getPractica() != null ? monitoring.getPractica().getId() : null)
                .coordinadorId(monitoring.getCoordinador() != null ? monitoring.getCoordinador().getId() : null)
                .tipoSeguimiento(monitoring.getTipoSeguimiento())
                .descripcion(monitoring.getDescripcion())
                .fechaRegistro(monitoring.getFechaRegistro())
                .build();
    }

    public static Monitoring toEntity(MonitoringDTO dto) {

        if (dto == null) {
            return null;
        }

        Practice practice = new Practice();
        practice.setId(dto.getPracticaId());

        User coordinator = new User();
        coordinator.setId(dto.getCoordinadorId());

        return Monitoring.builder()
                .id(dto.getId())
                .practica(practice)
                .coordinador(coordinator)
                .tipoSeguimiento(dto.getTipoSeguimiento())
                .descripcion(dto.getDescripcion())
                .fechaRegistro(dto.getFechaRegistro())
                .build();
    }
}