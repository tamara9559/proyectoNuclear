package com.proyecto.nuclear.DTO;

import com.proyecto.nuclear.enums.EstadoPractica;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PracticeDTO {

    private Long id;

    private Long estudianteId;

    private Long empresaId;

    private Long vacanteId;

    private Long convenioId;

    private String ciudad;

    private String tutorEmpresarial;

    private String correoTutor;

    private String tipoContrato;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private Integer duracionSemanas;

    private EstadoPractica estado;

    private Boolean requiereMovilidad;

    private String observaciones;

}
