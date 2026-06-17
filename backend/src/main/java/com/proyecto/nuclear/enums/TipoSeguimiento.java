package com.proyecto.nuclear.enums;


import com.fasterxml.jackson.annotation.JsonCreator;

public enum TipoSeguimiento {

    VISITA,
    LLAMADA,
    REUNION,
    OBSERVACION,
    DESVINCULACION,
    MOVILIDAD;

    @JsonCreator
    public static RolUsuario fromValue(
            String value) {

        return RolUsuario.valueOf(
                value.toUpperCase());
    }

}
