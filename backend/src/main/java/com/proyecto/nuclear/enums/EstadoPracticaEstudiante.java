package com.proyecto.nuclear.enums;


import com.fasterxml.jackson.annotation.JsonCreator;

public enum EstadoPracticaEstudiante {

    SIN_ASIGNAR,
    EN_PROCESO,
    ASIGNADO,
    EN_PRACTICA,
    FINALIZADO,
    CANCELADO;

    @JsonCreator
    public static RolUsuario fromValue(
            String value) {

        return RolUsuario.valueOf(
                value.toUpperCase());
    }

}
