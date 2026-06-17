package com.proyecto.nuclear.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TipoDocumento {

    HOJA_VIDA,
    CONVENIO_MARCO,
    CONVENIO_ESPECIFICO,
    CONTRATO_APRENDIZAJE,
    MOVILIDAD,
    CAMARA_COMERCIO,
    CEDULA_REPRESENTANTE,
    OTRO;

    @JsonCreator
    public static RolUsuario fromValue(
            String value) {

        return RolUsuario.valueOf(
                value.toUpperCase());
    }

}
