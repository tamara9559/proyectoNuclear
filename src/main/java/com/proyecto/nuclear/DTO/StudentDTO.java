package com.proyecto.nuclear.DTO;

import com.proyecto.nuclear.enums.EstadoPracticaEstudiante;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {

    private Long id;

    private Long usuarioId;

    private String codigoEstudiantil;

    private String carrera;

    private Integer semestre;

    private BigDecimal promedio;

    private String descripcionPerfil;

    private String competencias;

    private String habilidades;

    private String disponibilidad;

    private String ciudad;

    private String hojaVidaUrl;

    private EstadoPracticaEstudiante estadoPractica;

    private LocalDateTime fechaActualizacion;

}