package com.proyecto.nuclear.entity;

import com.proyecto.nuclear.enums.TipoSeguimiento;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "seguimientos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Monitoring {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_seguimiento")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "practica_id")
    private Practice practica;

    @ManyToOne
    @JoinColumn(name = "coordinador_id")
    private User coordinador;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_seguimiento")
    private TipoSeguimiento tipoSeguimiento;

    private String descripcion;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

}
