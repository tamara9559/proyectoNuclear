package com.proyecto.nuclear.controller;

import com.proyecto.nuclear.DTO.VacancyDTO;
import com.proyecto.nuclear.mapper.VacancyMapper;
import com.proyecto.nuclear.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacancies")
@RequiredArgsConstructor
public class VacancyController {

    private final VacancyService vacancyService;

    @PostMapping
    public ResponseEntity<VacancyDTO> create(
            @RequestBody VacancyDTO dto) {

        return ResponseEntity.ok(
                VacancyMapper.toDTO(
                        vacancyService.createVacancy(
                                VacancyMapper.toEntity(dto)
                        )
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<VacancyDTO> update(
            @PathVariable Long id,
            @RequestBody VacancyDTO dto) {

        return ResponseEntity.ok(
                VacancyMapper.toDTO(
                        vacancyService.updateVacancy(
                                id,
                                VacancyMapper.toEntity(dto)
                        )
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<VacancyDTO> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                VacancyMapper.toDTO(
                        vacancyService.findById(id)
                )
        );
    }

    @GetMapping
    public ResponseEntity<List<VacancyDTO>> findAll() {

        return ResponseEntity.ok(
                vacancyService.findAll()
                        .stream()
                        .map(VacancyMapper::toDTO)
                        .toList()
        );
    }

    @GetMapping("/open")
    public ResponseEntity<List<VacancyDTO>> openVacancies() {

        return ResponseEntity.ok(
                vacancyService.findOpenVacancies()
                        .stream()
                        .map(VacancyMapper::toDTO)
                        .toList()
        );
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<VacancyDTO>> findByCompany(
            @PathVariable Long companyId) {

        return ResponseEntity.ok(
                vacancyService.findByCompany(companyId)
                        .stream()
                        .map(VacancyMapper::toDTO)
                        .toList()
        );
    }
}