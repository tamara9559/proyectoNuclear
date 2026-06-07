package com.proyecto.nuclear.controller;

import com.proyecto.nuclear.DTO.StudentDTO;
import com.proyecto.nuclear.enums.EstadoPracticaEstudiante;
import com.proyecto.nuclear.mapper.StudentMapper;
import com.proyecto.nuclear.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @PostMapping
    public ResponseEntity<StudentDTO> create(
            @RequestBody StudentDTO dto) {

        return ResponseEntity.ok(
                StudentMapper.toDTO(
                        studentService.createStudent(
                                StudentMapper.toEntity(dto)
                        )
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(
            @PathVariable Long id,
            @RequestBody StudentDTO dto) {

        return ResponseEntity.ok(
                StudentMapper.toDTO(
                        studentService.updateStudent(
                                id,
                                StudentMapper.toEntity(dto)
                        )
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                StudentMapper.toDTO(
                        studentService.findById(id)
                )
        );
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAll() {

        return ResponseEntity.ok(
                studentService.findAll()
                        .stream()
                        .map(StudentMapper::toDTO)
                        .toList()
        );
    }

    @GetMapping("/career/{career}")
    public ResponseEntity<List<StudentDTO>> findByCareer(
            @PathVariable String career) {

        return ResponseEntity.ok(
                studentService.findByCareer(career)
                        .stream()
                        .map(StudentMapper::toDTO)
                        .toList()
        );
    }

    @GetMapping("/availability/{availability}")
    public ResponseEntity<List<StudentDTO>> findByAvailability(
            @PathVariable String availability) {

        return ResponseEntity.ok(
                studentService.findByAvailability(availability)
                        .stream()
                        .map(StudentMapper::toDTO)
                        .toList()
        );
    }

    @GetMapping("/skills/{skills}")
    public ResponseEntity<List<StudentDTO>> findBySkills(
            @PathVariable String skills) {

        return ResponseEntity.ok(
                studentService.findBySkills(skills)
                        .stream()
                        .map(StudentMapper::toDTO)
                        .toList()
        );
    }

    @GetMapping("/competencies/{competencies}")
    public ResponseEntity<List<StudentDTO>> findByCompetencies(
            @PathVariable String competencies) {

        return ResponseEntity.ok(
                studentService.findByCompetencies(competencies)
                        .stream()
                        .map(StudentMapper::toDTO)
                        .toList()
        );
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Void> updateStatus(
            @PathVariable Long id,
            @RequestParam EstadoPracticaEstudiante status) {

        studentService.updatePracticeStatus(id, status);

        return ResponseEntity.ok().build();
    }
}