package com.proyecto.nuclear.controller;

import com.proyecto.nuclear.DTO.AgreementDTO;
import com.proyecto.nuclear.mapper.AgreementMapper;
import com.proyecto.nuclear.service.AgreementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agreements")
@RequiredArgsConstructor
public class AgreementController {

    private final AgreementService agreementService;

    @PostMapping
    public ResponseEntity<AgreementDTO> create(
            @RequestBody AgreementDTO dto) {

        return ResponseEntity.ok(
                AgreementMapper.toDTO(
                        agreementService.createAgreement(
                                AgreementMapper.toEntity(dto)
                        )
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgreementDTO> update(
            @PathVariable Long id,
            @RequestBody AgreementDTO dto) {

        return ResponseEntity.ok(
                AgreementMapper.toDTO(
                        agreementService.updateAgreement(
                                id,
                                AgreementMapper.toEntity(dto)
                        )
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgreementDTO> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                AgreementMapper.toDTO(
                        agreementService.findById(id)
                )
        );
    }

    @GetMapping
    public ResponseEntity<List<AgreementDTO>> findAll() {

        return ResponseEntity.ok(
                agreementService.findAll()
                        .stream()
                        .map(AgreementMapper::toDTO)
                        .toList()
        );
    }

    @PutMapping("/{id}/validate")
    public ResponseEntity<Void> validate(
            @PathVariable Long id) {

        agreementService.validateCompanyRequirements(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/sign-company")
    public ResponseEntity<Void> signCompany(
            @PathVariable Long id) {

        agreementService.signByCompany(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/sign-university")
    public ResponseEntity<Void> signUniversity(
            @PathVariable Long id) {

        agreementService.signByUniversity(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/sign-student")
    public ResponseEntity<Void> signStudent(
            @PathVariable Long id) {

        agreementService.signByStudent(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/activate")
    public ResponseEntity<Void> activate(
            @PathVariable Long id) {

        agreementService.activateAgreement(id);

        return ResponseEntity.ok().build();
    }
}