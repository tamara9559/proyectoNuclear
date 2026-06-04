package com.proyecto.nuclear.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "empresas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private User usuario;

    @Column(name = "razon_social")
    private String razonSocial;

    private String nit;

    private String sector;

    private String direccion;

    private String ciudad;

    private String telefono;

    @Column(name = "correo_contacto")
    private String correoContacto;

    @Column(name = "representante_legal")
    private String representanteLegal;

    private Boolean estado;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

}