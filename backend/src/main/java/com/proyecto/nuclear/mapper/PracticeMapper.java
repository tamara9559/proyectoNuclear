package com.proyecto.nuclear.mapper;

import com.proyecto.nuclear.DTO.PracticeDTO;
import com.proyecto.nuclear.entity.*;

public class PracticeMapper {

    public static PracticeDTO toDTO(Practice practice) {

        if (practice == null) {
            return null;
        }

        return PracticeDTO.builder()
                .id(practice.getId())
                .estudianteId(practice.getEstudiante() != null ? practice.getEstudiante().getId() : null)
                .empresaId(practice.getEmpresa() != null ? practice.getEmpresa().getId() : null)
                .vacanteId(practice.getVacante() != null ? practice.getVacante().getId() : null)
                .convenioId(practice.getConvenio() != null ? practice.getConvenio().getId() : null)
                .ciudad(practice.getCiudad())
                .tutorEmpresarial(practice.getTutorEmpresarial())
                .correoTutor(practice.getCorreoTutor())
                .tipoContrato(practice.getTipoContrato())
                .fechaInicio(practice.getFechaInicio())
                .fechaFin(practice.getFechaFin())
                .duracionSemanas(practice.getDuracionSemanas())
                .estado(practice.getEstado())
                .requiereMovilidad(practice.getRequiereMovilidad())
                .observaciones(practice.getObservaciones())
                .build();
    }

    public static Practice toEntity(PracticeDTO dto) {

        if (dto == null) {
            return null;
        }

        Student student = new Student();
        student.setId(dto.getEstudianteId());

        Company company = new Company();
        company.setId(dto.getEmpresaId());

        Vacancy vacancy = new Vacancy();
        vacancy.setId(dto.getVacanteId());

        Agreement agreement = new Agreement();
        agreement.setId(dto.getConvenioId());

        return Practice.builder()
                .id(dto.getId())
                .estudiante(student)
                .empresa(company)
                .vacante(vacancy)
                .convenio(agreement)
                .ciudad(dto.getCiudad())
                .tutorEmpresarial(dto.getTutorEmpresarial())
                .correoTutor(dto.getCorreoTutor())
                .tipoContrato(dto.getTipoContrato())
                .fechaInicio(dto.getFechaInicio())
                .fechaFin(dto.getFechaFin())
                .duracionSemanas(dto.getDuracionSemanas())
                .estado(dto.getEstado())
                .requiereMovilidad(dto.getRequiereMovilidad())
                .observaciones(dto.getObservaciones())
                .build();
    }
}