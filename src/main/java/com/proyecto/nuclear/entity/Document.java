package com.proyecto.nuclear.entity;

import com.proyecto.nuclear.enums.TipoDocumento;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "documentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_documento")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Student estudiante;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Company empresa;

    @ManyToOne
    @JoinColumn(name = "convenio_id")
    private Agreement convenio;

    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_documento")
    private TipoDocumento tipoDocumento;

    @Column(name = "url_archivo")
    private String urlArchivo;

    @Column(name = "fecha_carga")
    private LocalDateTime fechaCarga;

    private String estado;

}
