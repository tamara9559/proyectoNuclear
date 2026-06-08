package com.proyecto.nuclear.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EstadoApplication {

    ENVIADA,
    EN_REVISION,
    PRESELECCIONADO,
    ENTREVISTA,
    RECHAZADO,
    ACEPTADO,
    CONTRATADO;

    @JsonCreator
    public static RolUsuario fromValue(
            String value) {

        return RolUsuario.valueOf(
                value.toUpperCase());
    }

}
