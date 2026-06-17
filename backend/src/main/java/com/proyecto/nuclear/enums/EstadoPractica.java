package com.proyecto.nuclear.enums;


import com.fasterxml.jackson.annotation.JsonCreator;

public enum EstadoPractica {

    PENDIENTE,
    ACTIVA,
    FINALIZADA,
    CANCELADA;

    @JsonCreator
    public static RolUsuario fromValue(
            String value) {

        return RolUsuario.valueOf(
                value.toUpperCase());
    }

}
