package com.proyecto.nuclear.DTO;

import com.proyecto.nuclear.enums.RolUsuario;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private Long id;

    private String nombres;

    private String apellidos;

    private String correo;

    private String telefono;

    private RolUsuario rol;

    private Boolean estado;

    private LocalDateTime fechaCreacion;

    private LocalDateTime ultimoAcceso;

}
