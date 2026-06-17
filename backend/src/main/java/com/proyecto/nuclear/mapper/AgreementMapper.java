package com.proyecto.nuclear.mapper;

import com.proyecto.nuclear.DTO.AgreementDTO;
import com.proyecto.nuclear.entity.Agreement;
import com.proyecto.nuclear.entity.Company;

public class AgreementMapper {

    public static AgreementDTO toDTO(Agreement agreement) {

        if (agreement == null) {
            return null;
        }

        return AgreementDTO.builder()
                .id(agreement.getId())
                .empresaId(agreement.getEmpresa() != null ? agreement.getEmpresa().getId() : null)
                .tipoConvenio(agreement.getTipoConvenio())
                .fechaInicio(agreement.getFechaInicio())
                .fechaFin(agreement.getFechaFin())
                .estado(agreement.getEstado())
                .firmadoEmpresa(agreement.getFirmadoEmpresa())
                .firmadoUniversidad(agreement.getFirmadoUniversidad())
                .firmadoEstudiante(agreement.getFirmadoEstudiante())
                .certificadoCamaraComercio(agreement.getCertificadoCamaraComercio())
                .validado(agreement.getValidado())
                .observaciones(agreement.getObservaciones())
                .build();
    }

    public static Agreement toEntity(AgreementDTO dto) {

        if (dto == null) {
            return null;
        }

        Company company = new Company();
        company.setId(dto.getEmpresaId());

        return Agreement.builder()
                .id(dto.getId())
                .empresa(company)
                .tipoConvenio(dto.getTipoConvenio())
                .fechaInicio(dto.getFechaInicio())
                .fechaFin(dto.getFechaFin())
                .estado(dto.getEstado())
                .firmadoEmpresa(dto.getFirmadoEmpresa())
                .firmadoUniversidad(dto.getFirmadoUniversidad())
                .firmadoEstudiante(dto.getFirmadoEstudiante())
                .certificadoCamaraComercio(dto.getCertificadoCamaraComercio())
                .validado(dto.getValidado())
                .observaciones(dto.getObservaciones())
                .build();
    }
}