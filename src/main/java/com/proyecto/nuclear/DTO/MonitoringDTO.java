package com.proyecto.nuclear.DTO;

import com.proyecto.nuclear.enums.TipoSeguimiento;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MonitoringDTO {

    private Long id;

    private Long practicaId;

    private Long coordinadorId;

    private TipoSeguimiento tipoSeguimiento;

    private String descripcion;

    private LocalDateTime fechaRegistro;

}
