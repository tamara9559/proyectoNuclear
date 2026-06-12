package com.proyecto.nuclear.mapper;

import com.proyecto.nuclear.DTO.VacancyDTO;
import com.proyecto.nuclear.entity.Company;
import com.proyecto.nuclear.entity.Vacancy;

public class VacancyMapper {

    public static VacancyDTO toDTO(Vacancy vacancy) {

        if (vacancy == null) {
            return null;
        }

        return VacancyDTO.builder()
                .id(vacancy.getId())
                .empresaId(vacancy.getEmpresa().getId())
                .titulo(vacancy.getTitulo())
                .descripcion(vacancy.getDescripcion())
                .perfilRequerido(vacancy.getPerfilRequerido())
                .habilidadesRequeridas(vacancy.getHabilidadesRequeridas())
                .competenciasRequeridas(vacancy.getCompetenciasRequeridas())
                .carreraRequerida(vacancy.getCarreraRequerida())
                .tipoVacante(vacancy.getTipoVacante())
                .modalidad(vacancy.getModalidad())
                .ciudad(vacancy.getCiudad())
                .remuneracion(vacancy.getRemuneracion())
                .cupos(vacancy.getCupos())
                .estado(vacancy.getEstado())
                .fechaPublicacion(vacancy.getFechaPublicacion())
                .fechaCierre(vacancy.getFechaCierre())
                .build();
    }

    public static Vacancy toEntity(VacancyDTO dto) {

        Company company = new Company();
        company.setId(dto.getEmpresaId());

        return Vacancy.builder()
                .id(dto.getId())
                .empresa(company)
                .titulo(dto.getTitulo())
                .descripcion(dto.getDescripcion())
                .perfilRequerido(dto.getPerfilRequerido())
                .habilidadesRequeridas(dto.getHabilidadesRequeridas())
                .competenciasRequeridas(dto.getCompetenciasRequeridas())
                .carreraRequerida(dto.getCarreraRequerida())
                .tipoVacante(dto.getTipoVacante())
                .modalidad(dto.getModalidad())
                .ciudad(dto.getCiudad())
                .remuneracion(dto.getRemuneracion())
                .cupos(dto.getCupos())
                .estado(dto.getEstado())
                .fechaPublicacion(dto.getFechaPublicacion())
                .fechaCierre(dto.getFechaCierre())
                .build();
    }
}
