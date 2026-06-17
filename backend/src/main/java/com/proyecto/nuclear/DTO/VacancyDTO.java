package com.proyecto.nuclear.DTO;

import com.proyecto.nuclear.enums.EstadoVacante;
import com.proyecto.nuclear.enums.TipoVacante;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VacancyDTO {

    private Long id;

    private Long empresaId;

    private String titulo;

    private String descripcion;

    private String perfilRequerido;

    private String habilidadesRequeridas;

    private String competenciasRequeridas;

    private String carreraRequerida;

    private TipoVacante tipoVacante;

    private String modalidad;

    private String ciudad;

    private BigDecimal remuneracion;

    private Integer cupos;

    private EstadoVacante estado;

    private LocalDateTime fechaPublicacion;

    private LocalDateTime fechaCierre;

}
