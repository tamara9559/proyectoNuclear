package com.proyecto.nuclear.controller;

import com.proyecto.nuclear.DTO.StudentDTO;
import com.proyecto.nuclear.DTO.VacancyDTO;
import com.proyecto.nuclear.mapper.StudentMapper;
import com.proyecto.nuclear.mapper.VacancyMapper;
import com.proyecto.nuclear.service.MatchingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matching")
@RequiredArgsConstructor
public class MatchingController {

    private final MatchingService matchingService;

    @GetMapping("/students/{vacancyId}")
    public ResponseEntity<List<StudentDTO>> compatibleStudents(
            @PathVariable Long vacancyId) {

        return ResponseEntity.ok(
                matchingService.findCompatibleStudents(vacancyId)
                        .stream()
                        .map(StudentMapper::toDTO)
                        .toList()
        );
    }

    @GetMapping("/vacancies/{studentId}")
    public ResponseEntity<List<VacancyDTO>> compatibleVacancies(
            @PathVariable Long studentId) {

        return ResponseEntity.ok(
                matchingService.findCompatibleVacancies(studentId)
                        .stream()
                        .map(VacancyMapper::toDTO)
                        .toList()
        );
    }

    @GetMapping("/ranking/{vacancyId}")
    public ResponseEntity<List<StudentDTO>> rankCandidates(
            @PathVariable Long vacancyId) {

        return ResponseEntity.ok(
                matchingService.rankCandidates(vacancyId)
                        .stream()
                        .map(StudentMapper::toDTO)
                        .toList()
        );
    }
}