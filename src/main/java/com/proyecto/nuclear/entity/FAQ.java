package com.proyecto.nuclear.entity;

import com.proyecto.nuclear.enums.CategoriaFAQ;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "faq")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FAQ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_faq")
    private Long id;

    private String pregunta;

    private String respuesta;

    @Enumerated(EnumType.STRING)
    private CategoriaFAQ categoria;

    private Boolean estado;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

}
