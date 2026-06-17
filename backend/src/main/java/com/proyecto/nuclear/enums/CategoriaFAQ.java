package com.proyecto.nuclear.enums;


import com.fasterxml.jackson.annotation.JsonCreator;

public enum CategoriaFAQ {

    CONTRATOS,
    PAGOS,
    DURACION,
    MODALIDADES,
    POSTULACIONES;

    @JsonCreator
    public static RolUsuario fromValue(
            String value) {

        return RolUsuario.valueOf(
                value.toUpperCase());
    }

}
