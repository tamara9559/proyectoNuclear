package com.proyecto.nuclear.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TipoVacante {

    PRACTICA,
    EMPLEO;

    @JsonCreator
    public static RolUsuario fromValue(
            String value) {

        return RolUsuario.valueOf(
                value.toUpperCase());
    }

}
