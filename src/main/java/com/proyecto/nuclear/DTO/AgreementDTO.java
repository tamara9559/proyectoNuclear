package com.proyecto.nuclear.DTO;

import com.proyecto.nuclear.enums.TipoConvenio;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgreementDTO {

    private Long id;

    private Long empresaId;

    private TipoConvenio tipoConvenio;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private String estado;

    private Boolean firmadoEmpresa;

    private Boolean firmadoUniversidad;

    private Boolean firmadoEstudiante;

    private Boolean certificadoCamaraComercio;

    private Boolean validado;

    private String observaciones;

}
