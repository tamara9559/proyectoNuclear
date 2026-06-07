package com.proyecto.nuclear.controller;

import com.proyecto.nuclear.DTO.ApplicationDTO;
import com.proyecto.nuclear.entity.Application;
import com.proyecto.nuclear.mapper.ApplicationMapper;
import com.proyecto.nuclear.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<ApplicationDTO> apply(
            @RequestBody ApplicationDTO dto) {

        Application application =
                applicationService.apply(
                        dto.getUsuarioId(),
                        dto.getVacanteId()
                );

        return ResponseEntity.ok(
                ApplicationMapper.toDTO(application)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationDTO> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                ApplicationMapper.toDTO(
                        applicationService.findById(id)
                )
        );
    }

    @GetMapping
    public ResponseEntity<List<ApplicationDTO>> findAll() {

        return ResponseEntity.ok(
                applicationService.findAll()
                        .stream()
                        .map(ApplicationMapper::toDTO)
                        .toList()
        );
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ApplicationDTO>> findByUser(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                applicationService.findByUser(userId)
                        .stream()
                        .map(ApplicationMapper::toDTO)
                        .toList()
        );
    }

    @GetMapping("/vacancy/{vacancyId}")
    public ResponseEntity<List<ApplicationDTO>> findByVacancy(
            @PathVariable Long vacancyId) {

        return ResponseEntity.ok(
                applicationService.findByVacancy(vacancyId)
                        .stream()
                        .map(ApplicationMapper::toDTO)
                        .toList()
        );
    }
}