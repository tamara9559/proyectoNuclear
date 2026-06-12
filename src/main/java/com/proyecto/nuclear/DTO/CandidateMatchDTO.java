package com.proyecto.nuclear.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateMatchDTO {

    private Long studentId;

    private String nombre;

    private String carrera;

    private Double compatibility;

}