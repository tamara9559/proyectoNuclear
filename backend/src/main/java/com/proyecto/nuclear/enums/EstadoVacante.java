package com.proyecto.nuclear.enums;


import com.fasterxml.jackson.annotation.JsonCreator;

public enum EstadoVacante {

    ABIERTA,
    CERRADA,
    SUSPENDIDA;

    @JsonCreator
    public static RolUsuario fromValue(
            String value) {

        return RolUsuario.valueOf(
                value.toUpperCase());
    }

}
