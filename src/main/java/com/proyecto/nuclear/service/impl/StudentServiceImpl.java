package com.proyecto.nuclear.service.impl;

import com.proyecto.nuclear.entity.Student;
import com.proyecto.nuclear.enums.EstadoPracticaEstudiante;
import com.proyecto.nuclear.exception.ResourceNotFoundException;
import com.proyecto.nuclear.repository.StudentRepository;
import com.proyecto.nuclear.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        student.setFechaActualizacion(LocalDateTime.now());
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(
            Long id,
            Student student
    ) {
        Student existing =
                findById(id);
        if (
                student.getCarrera()
                        != null
        ) {
            existing.setCarrera(
                    student.getCarrera()
            );
        }
        if (
                student.getSemestre()
                        != null
        ) {
            existing.setSemestre(
                    student.getSemestre()
            );
        }
        if (
                student.getHabilidades()
                        != null
        ) {
            existing.setHabilidades(
                    student.getHabilidades()
            );
        }
        if (
                student.getCompetencias()
                        != null
        ) {
            existing.setCompetencias(
                    student.getCompetencias()
            );
        }
        if (
                student.getDisponibilidad()
                        != null
        ) {
            existing.setDisponibilidad(
                    student.getDisponibilidad()
            );
        }
        if (
                student.getDescripcionPerfil()
                        != null
        ) {
            existing.setDescripcionPerfil(
                    student.getDescripcionPerfil()
            );
        }
        existing.setFechaActualizacion(
                LocalDateTime.now()
        );
        return studentRepository.save(
                existing
        );
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado"));
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findByCareer(String career) {
        return studentRepository.findByCarrera(career);
    }

    @Override
    public List<Student> findByAvailability(String availability) {
        return studentRepository.findByDisponibilidad(availability);
    }

    @Override
    public List<Student> findBySkills(String skills) {
        return studentRepository.findByHabilidadesContainingIgnoreCase(skills);
    }

    @Override
    public List<Student> findByCompetencies(String competencies) {
        return studentRepository.findByCompetenciasContainingIgnoreCase(competencies);
    }

    @Override
    public void updatePracticeStatus(Long studentId, EstadoPracticaEstudiante status) {
        Student student = findById(studentId);
        student.setEstadoPractica(status);
        studentRepository.save(student);
    }

    @Override
    public List<Student> filterStudents(String career, String skills, String competencies, String availability) {
        return studentRepository.findAll().stream()
                .filter(s -> career == null || s.getCarrera().equalsIgnoreCase(career))
                .filter(s -> skills == null || s.getHabilidades().toLowerCase().contains(skills.toLowerCase()))
                .filter(s -> competencies == null || s.getCompetencias().toLowerCase().contains(competencies.toLowerCase()))
                .filter(s -> availability == null || s.getDisponibilidad().equalsIgnoreCase(availability))
                .toList();
    }
}
