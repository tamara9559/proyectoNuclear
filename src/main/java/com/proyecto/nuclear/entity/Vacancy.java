package com.proyecto.nuclear.entity;

import com.proyecto.nuclear.enums.EstadoVacante;
import com.proyecto.nuclear.enums.TipoVacante;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "vacantes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vacante")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Company empresa;

    private String titulo;

    private String descripcion;

    @Column(name = "perfil_requerido")
    private String perfilRequerido;

    @Column(name = "habilidades_requeridas")
    private String habilidadesRequeridas;

    @Column(name = "carrera_requerida")
    private String carreraRequerida;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_vacante")
    private TipoVacante tipoVacante;

    private String modalidad;

    private String ciudad;

    private BigDecimal remuneracion;

    private Integer cupos;

    @Enumerated(EnumType.STRING)
    private EstadoVacante estado;

    @Column(name = "fecha_publicacion")
    private LocalDateTime fechaPublicacion;

    @Column(name = "fecha_cierre")
    private LocalDateTime fechaCierre;

}
