package com.proyecto.nuclear.mapper;

import com.proyecto.nuclear.DTO.DocumentDTO;
import com.proyecto.nuclear.entity.*;

public class DocumentMapper {

    public static DocumentDTO toDTO(Document document) {

        if (document == null) {
            return null;
        }

        return DocumentDTO.builder()
                .id(document.getId())
                .estudianteId(document.getEstudiante() != null ? document.getEstudiante().getId() : null)
                .empresaId(document.getEmpresa() != null ? document.getEmpresa().getId() : null)
                .convenioId(document.getConvenio() != null ? document.getConvenio().getId() : null)
                .nombre(document.getNombre())
                .tipoDocumento(document.getTipoDocumento())
                .urlArchivo(document.getUrlArchivo())
                .fechaCarga(document.getFechaCarga())
                .estado(document.getEstado())
                .build();
    }

    public static Document toEntity(DocumentDTO dto) {

        if (dto == null) {
            return null;
        }

        Student student = new Student();
        student.setId(dto.getEstudianteId());

        Company company = new Company();
        company.setId(dto.getEmpresaId());

        Agreement agreement = new Agreement();
        agreement.setId(dto.getConvenioId());

        return Document.builder()
                .id(dto.getId())
                .estudiante(student)
                .empresa(company)
                .convenio(agreement)
                .nombre(dto.getNombre())
                .tipoDocumento(dto.getTipoDocumento())
                .urlArchivo(dto.getUrlArchivo())
                .fechaCarga(dto.getFechaCarga())
                .estado(dto.getEstado())
                .build();
    }
}