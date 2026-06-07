package com.proyecto.nuclear.controller;

import com.proyecto.nuclear.DTO.DocumentDTO;
import com.proyecto.nuclear.mapper.DocumentMapper;
import com.proyecto.nuclear.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping
    public ResponseEntity<DocumentDTO> upload(
            @RequestBody DocumentDTO dto) {

        return ResponseEntity.ok(
                DocumentMapper.toDTO(
                        documentService.uploadDocument(
                                DocumentMapper.toEntity(dto)
                        )
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentDTO> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                DocumentMapper.toDTO(
                        documentService.findById(id)
                )
        );
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<DocumentDTO>> findByStudent(
            @PathVariable Long studentId) {

        return ResponseEntity.ok(
                documentService.findByStudent(studentId)
                        .stream()
                        .map(DocumentMapper::toDTO)
                        .toList()
        );
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<DocumentDTO>> findByCompany(
            @PathVariable Long companyId) {

        return ResponseEntity.ok(
                documentService.findByCompany(companyId)
                        .stream()
                        .map(DocumentMapper::toDTO)
                        .toList()
        );
    }

    @GetMapping("/agreement/{agreementId}")
    public ResponseEntity<List<DocumentDTO>> findByAgreement(
            @PathVariable Long agreementId) {

        return ResponseEntity.ok(
                documentService.findByAgreement(agreementId)
                        .stream()
                        .map(DocumentMapper::toDTO)
                        .toList()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        documentService.deleteDocument(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/generate/agreement/{agreementId}")
    public ResponseEntity<String> generateAgreement(
            @PathVariable Long agreementId) {

        return ResponseEntity.ok(
                documentService.generateAgreementDocument(
                        agreementId)
        );
    }

    @GetMapping("/generate/learning-contract/{practiceId}")
    public ResponseEntity<String> generateLearningContract(
            @PathVariable Long practiceId) {

        return ResponseEntity.ok(
                documentService.generateLearningContract(
                        practiceId)
        );
    }

    @GetMapping("/generate/mobility/{practiceId}")
    public ResponseEntity<String> generateMobility(
            @PathVariable Long practiceId) {

        return ResponseEntity.ok(
                documentService.generateMobilityForm(
                        practiceId)
        );
    }
}