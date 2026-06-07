package com.proyecto.nuclear.mapper;

import com.proyecto.nuclear.DTO.FAQDTO;
import com.proyecto.nuclear.entity.FAQ;

public class FAQMapper {

    public static FAQDTO toDTO(FAQ faq) {

        if (faq == null) {
            return null;
        }

        return FAQDTO.builder()
                .id(faq.getId())
                .pregunta(faq.getPregunta())
                .respuesta(faq.getRespuesta())
                .categoria(faq.getCategoria())
                .estado(faq.getEstado())
                .fechaCreacion(faq.getFechaCreacion())
                .build();
    }

    public static FAQ toEntity(FAQDTO dto) {

        if (dto == null) {
            return null;
        }

        return FAQ.builder()
                .id(dto.getId())
                .pregunta(dto.getPregunta())
                .respuesta(dto.getRespuesta())
                .categoria(dto.getCategoria())
                .estado(dto.getEstado())
                .fechaCreacion(dto.getFechaCreacion())
                .build();
    }
}