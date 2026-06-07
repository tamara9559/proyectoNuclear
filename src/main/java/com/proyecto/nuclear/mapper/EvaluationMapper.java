package com.proyecto.nuclear.mapper;

import com.proyecto.nuclear.DTO.EvaluationDTO;
import com.proyecto.nuclear.entity.Evaluation;
import com.proyecto.nuclear.entity.Practice;

public class EvaluationMapper {

    public static EvaluationDTO toDTO(Evaluation evaluation) {

        if (evaluation == null) {
            return null;
        }

        return EvaluationDTO.builder()
                .id(evaluation.getId())
                .practicaId(evaluation.getPractica() != null ? evaluation.getPractica().getId() : null)
                .evaluador(evaluation.getEvaluador())
                .calificacion(evaluation.getCalificacion())
                .fortalezas(evaluation.getFortalezas())
                .oportunidadesMejora(evaluation.getOportunidadesMejora())
                .observaciones(evaluation.getObservaciones())
                .fechaEvaluacion(evaluation.getFechaEvaluacion())
                .build();
    }

    public static Evaluation toEntity(EvaluationDTO dto) {

        if (dto == null) {
            return null;
        }

        Practice practice = new Practice();
        practice.setId(dto.getPracticaId());

        return Evaluation.builder()
                .id(dto.getId())
                .practica(practice)
                .evaluador(dto.getEvaluador())
                .calificacion(dto.getCalificacion())
                .fortalezas(dto.getFortalezas())
                .oportunidadesMejora(dto.getOportunidadesMejora())
                .observaciones(dto.getObservaciones())
                .fechaEvaluacion(dto.getFechaEvaluacion())
                .build();
    }
}