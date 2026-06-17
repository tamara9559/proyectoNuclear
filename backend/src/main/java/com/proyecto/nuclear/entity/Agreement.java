package com.proyecto.nuclear.entity;

import com.proyecto.nuclear.enums.TipoConvenio;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "convenios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Agreement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_convenio")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Company empresa;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_convenio")
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
