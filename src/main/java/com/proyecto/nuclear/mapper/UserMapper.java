package com.proyecto.nuclear.mapper;


import com.proyecto.nuclear.DTO.UserDTO;
import com.proyecto.nuclear.entity.User;

public class UserMapper {

    public static UserDTO toDTO(User user) {

        if (user == null) {
            return null;
        }

        return UserDTO.builder()
                .id(user.getId())
                .nombres(user.getNombres())
                .apellidos(user.getApellidos())
                .correo(user.getCorreo())
                .telefono(user.getTelefono())
                .rol(user.getRol())
                .estado(user.getEstado())
                .fechaCreacion(user.getFechaCreacion())
                .ultimoAcceso(user.getUltimoAcceso())
                .build();
    }

    public static User toEntity(UserDTO dto) {

        if (dto == null) {
            return null;
        }

        return User.builder()
                .id(dto.getId())
                .nombres(dto.getNombres())
                .apellidos(dto.getApellidos())
                .correo(dto.getCorreo())
                .telefono(dto.getTelefono())
                .rol(dto.getRol())
                .estado(dto.getEstado())
                .fechaCreacion(dto.getFechaCreacion())
                .ultimoAcceso(dto.getUltimoAcceso())
                .build();
    }
}
