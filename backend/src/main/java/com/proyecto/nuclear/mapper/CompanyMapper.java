package com.proyecto.nuclear.mapper;

import com.proyecto.nuclear.DTO.CompanyDTO;
import com.proyecto.nuclear.entity.Company;
import com.proyecto.nuclear.entity.User;

public class CompanyMapper {

    public static CompanyDTO toDTO(Company company) {

        if (company == null) {
            return null;
        }

        return CompanyDTO.builder()
                .id(company.getId())
                .usuarioId(company.getUsuario().getId())
                .razonSocial(company.getRazonSocial())
                .nit(company.getNit())
                .sector(company.getSector())
                .direccion(company.getDireccion())
                .ciudad(company.getCiudad())
                .telefono(company.getTelefono())
                .correoContacto(company.getCorreoContacto())
                .representanteLegal(company.getRepresentanteLegal())
                .estado(company.getEstado())
                .fechaRegistro(company.getFechaRegistro())
                .build();
    }

    public static Company toEntity(CompanyDTO dto) {

        User usuario = new User();
        usuario.setId(dto.getUsuarioId());

        return Company.builder()
                .id(dto.getId())
                .usuario(usuario)
                .razonSocial(dto.getRazonSocial())
                .nit(dto.getNit())
                .sector(dto.getSector())
                .direccion(dto.getDireccion())
                .ciudad(dto.getCiudad())
                .telefono(dto.getTelefono())
                .correoContacto(dto.getCorreoContacto())
                .representanteLegal(dto.getRepresentanteLegal())
                .estado(dto.getEstado())
                .fechaRegistro(dto.getFechaRegistro())
                .build();
    }
}
