package com.proyecto.nuclear.entity;

import com.proyecto.nuclear.enums.RolUsuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    private String nombres;

    private String apellidos;

    @Column(unique = true)
    private String correo;

    @Column(name = "password_hash")
    private String passwordHash;

    private String telefono;

    @Enumerated(EnumType.STRING)
    private RolUsuario rol;

    private Boolean estado;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "ultimo_acceso")
    private LocalDateTime ultimoAcceso;

}
