package com.proyecto.nuclear.mapper;

import com.proyecto.nuclear.DTO.ApplicationDTO;
import com.proyecto.nuclear.entity.Application;
import com.proyecto.nuclear.entity.User;
import com.proyecto.nuclear.entity.Vacancy;

public class ApplicationMapper {

    public static ApplicationDTO toDTO(Application application) {

        if (application == null) {
            return null;
        }

        return ApplicationDTO.builder()
                .id(application.getId())
                .usuarioId(application.getUsuario().getId())
                .vacanteId(application.getVacante().getId())
                .estado(application.getEstado())
                .fechaPostulacion(application.getFechaPostulacion())
                .observaciones(application.getObservaciones())
                .build();
    }

    public static Application toEntity(ApplicationDTO dto) {

        if (dto == null) {
            return null;
        }

        User user = new User();
        user.setId(dto.getUsuarioId());

        Vacancy vacancy = new Vacancy();
        vacancy.setId(dto.getVacanteId());

        return Application.builder()
                .id(dto.getId())
                .usuario(user)
                .vacante(vacancy)
                .estado(dto.getEstado())
                .fechaPostulacion(dto.getFechaPostulacion())
                .observaciones(dto.getObservaciones())
                .build();
    }
}