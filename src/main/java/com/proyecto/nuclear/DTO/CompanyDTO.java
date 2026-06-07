package com.proyecto.nuclear.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyDTO {

    private Long id;

    private Long usuarioId;

    private String razonSocial;

    private String nit;

    private String sector;

    private String direccion;

    private String ciudad;

    private String telefono;

    private String correoContacto;

    private String representanteLegal;

    private Boolean estado;

    private LocalDateTime fechaRegistro;

}
