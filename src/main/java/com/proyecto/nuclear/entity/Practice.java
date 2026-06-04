package com.proyecto.nuclear.entity;

import com.proyecto.nuclear.enums.EstadoPractica;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "practicas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Practice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_practica")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Student estudiante;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Company empresa;

    @ManyToOne
    @JoinColumn(name = "vacante_id")
    private Vacancy vacante;

    @ManyToOne
    @JoinColumn(name = "convenio_id")
    private Agreement convenio;

    private String ciudad;

    @Column(name = "tutor_empresarial")
    private String tutorEmpresarial;

    @Column(name = "correo_tutor")
    private String correoTutor;

    @Column(name = "tipo_contrato")
    private String tipoContrato;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "duracion_semanas")
    private Integer duracionSemanas;

    @Enumerated(EnumType.STRING)
    private EstadoPractica estado;

    @Column(name = "requiere_movilidad")
    private Boolean requiereMovilidad;

    private String observaciones;

}