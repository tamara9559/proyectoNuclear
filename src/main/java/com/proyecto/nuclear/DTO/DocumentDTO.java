package com.proyecto.nuclear.DTO;



import com.proyecto.nuclear.enums.TipoDocumento;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentDTO {

    private Long id;

    private Long estudianteId;

    private Long empresaId;

    private Long convenioId;

    private String nombre;

    private TipoDocumento tipoDocumento;

    private String urlArchivo;

    private LocalDateTime fechaCarga;

    private String estado;

}
