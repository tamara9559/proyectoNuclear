package com.proyecto.nuclear.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TipoConvenio {

    MARCO,
    ESPECIFICO,
    APRENDIZAJE;

    @JsonCreator
    public static RolUsuario fromValue(
            String value) {

        return RolUsuario.valueOf(
                value.toUpperCase());
    }

}
