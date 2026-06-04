package com.proyecto.nuclear.service;


import com.proyecto.nuclear.entity.Student;
import com.proyecto.nuclear.enums.EstadoPracticaEstudiante;

import java.util.List;

public interface StudentService {

    Student createStudent(Student student);

    Student updateStudent(Long id, Student student);

    Student findById(Long id);

    List<Student> findAll();

    List<Student> findByCareer(String career);

    List<Student> findByAvailability(String availability);

    List<Student> findBySkills(String skills);

    List<Student> findByCompetencies(String competencies);

    void updatePracticeStatus(
            Long studentId,
            EstadoPracticaEstudiante status);

    List<Student> filterStudents(
            String career,
            String skills,
            String competencies,
            String availability);
}
