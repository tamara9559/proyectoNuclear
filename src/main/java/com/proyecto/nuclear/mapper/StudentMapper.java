package com.proyecto.nuclear.mapper;

import com.proyecto.nuclear.DTO.StudentDTO;
import com.proyecto.nuclear.entity.Student;
import com.proyecto.nuclear.entity.User;

public class StudentMapper {

    public static StudentDTO toDTO(Student student) {

        if (student == null) {
            return null;
        }

        return StudentDTO.builder()
                .id(student.getId())
                .usuarioId(student.getUsuario().getId())
                .codigoEstudiantil(student.getCodigoEstudiantil())
                .carrera(student.getCarrera())
                .semestre(student.getSemestre())
                .promedio(student.getPromedio())
                .descripcionPerfil(student.getDescripcionPerfil())
                .competencias(student.getCompetencias())
                .habilidades(student.getHabilidades())
                .disponibilidad(student.getDisponibilidad())
                .ciudad(student.getCiudad())
                .hojaVidaUrl(student.getHojaVidaUrl())
                .estadoPractica(student.getEstadoPractica())
                .fechaActualizacion(student.getFechaActualizacion())
                .build();
    }

    public static Student toEntity(StudentDTO dto) {

        if (dto == null) {
            return null;
        }

        User usuario = new User();
        usuario.setId(dto.getUsuarioId());

        return Student.builder()
                .id(dto.getId())
                .usuario(usuario)
                .codigoEstudiantil(dto.getCodigoEstudiantil())
                .carrera(dto.getCarrera())
                .semestre(dto.getSemestre())
                .promedio(dto.getPromedio())
                .descripcionPerfil(dto.getDescripcionPerfil())
                .competencias(dto.getCompetencias())
                .habilidades(dto.getHabilidades())
                .disponibilidad(dto.getDisponibilidad())
                .ciudad(dto.getCiudad())
                .hojaVidaUrl(dto.getHojaVidaUrl())
                .estadoPractica(dto.getEstadoPractica())
                .fechaActualizacion(dto.getFechaActualizacion())
                .build();
    }
}
