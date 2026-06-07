package com.proyecto.nuclear.DTO;

import com.proyecto.nuclear.enums.CategoriaFAQ;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FAQDTO {

    private Long id;

    private String pregunta;

    private String respuesta;

    private CategoriaFAQ categoria;

    private Boolean estado;

    private LocalDateTime fechaCreacion;

}
