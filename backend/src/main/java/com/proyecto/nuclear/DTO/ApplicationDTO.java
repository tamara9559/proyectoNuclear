package com.proyecto.nuclear.DTO;

import com.proyecto.nuclear.enums.EstadoApplication;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationDTO {

    private Long id;

    private Long usuarioId;

    private Long vacanteId;

    private EstadoApplication estado;

    private LocalDateTime fechaPostulacion;

    private String observaciones;

}
