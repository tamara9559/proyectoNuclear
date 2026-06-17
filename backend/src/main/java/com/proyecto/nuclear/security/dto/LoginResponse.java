package com.proyecto.nuclear.security.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

    private String token;

    private Long userId;

    private String correo;

    private String rol;

}