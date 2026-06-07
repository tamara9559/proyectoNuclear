package com.proyecto.nuclear.entity;

import com.proyecto.nuclear.enums.EstadoApplication;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "applications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_application")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User usuario;

    @ManyToOne
    @JoinColumn(name = "vacante_id")
    private Vacancy vacante;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoApplication estado;

    @Column(name = "fecha_postulacion")
    private LocalDateTime fechaPostulacion;

    @Column(name = "comentarios")
    private String observaciones;

}
