package com.proyecto.nuclear.DTO;

import com.proyecto.nuclear.enums.TipoEvaluador;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvaluationDTO {

    private Long id;

    private Long practicaId;

    private TipoEvaluador evaluador;

    private BigDecimal calificacion;

    private String fortalezas;

    private String oportunidadesMejora;

    private String observaciones;

    private LocalDate fechaEvaluacion;

}
