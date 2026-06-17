package com.proyecto.nuclear.entity;

import com.proyecto.nuclear.enums.EstadoPracticaEstudiante;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "estudiantes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private User usuario;

    @Column(name = "codigo_estudiantil")
    private String codigoEstudiantil;

    private String carrera;

    private Integer semestre;

    private BigDecimal promedio;

    @Column(name = "descripcion_perfil")
    private String descripcionPerfil;

    private String competencias;

    private String habilidades;

    private String disponibilidad;

    private String ciudad;

    @Column(name = "hoja_vida_url")
    private String hojaVidaUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_practica")
    private EstadoPracticaEstudiante estadoPractica;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

}
