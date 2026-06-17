package com.proyecto.nuclear.entity;

import com.proyecto.nuclear.enums.TipoEvaluador;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "evaluaciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evaluacion")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "practica_id")
    private Practice practica;

    @Enumerated(EnumType.STRING)
    private TipoEvaluador evaluador;

    private BigDecimal calificacion;

    private String fortalezas;

    @Column(name = "oportunidades_mejora")
    private String oportunidadesMejora;

    private String observaciones;

    @Column(name = "fecha_evaluacion")
    private LocalDate fechaEvaluacion;

}
