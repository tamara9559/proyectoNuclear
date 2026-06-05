package com.proyecto.nuclear.repository;

import com.proyecto.nuclear.entity.Student;
import com.proyecto.nuclear.enums.EstadoPracticaEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByCarrera(String carrera);

    List<Student> findByDisponibilidad(String disponibilidad);

    List<Student> findByEstadoPractica(
            EstadoPracticaEstudiante estadoPractica);

    List<Student> findByHabilidadesContainingIgnoreCase(
            String habilidades);

    List<Student> findByCompetenciasContainingIgnoreCase(
            String competencias);

}
