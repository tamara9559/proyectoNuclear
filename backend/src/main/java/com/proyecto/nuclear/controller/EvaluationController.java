package com.proyecto.nuclear.controller;

import com.proyecto.nuclear.DTO.EvaluationDTO;
import com.proyecto.nuclear.mapper.EvaluationMapper;
import com.proyecto.nuclear.service.EvaluationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluations")
@RequiredArgsConstructor
public class EvaluationController {

    private final EvaluationService evaluationService;

    @PostMapping
    public ResponseEntity<EvaluationDTO> create(
            @RequestBody EvaluationDTO dto) {

        return ResponseEntity.ok(
                EvaluationMapper.toDTO(
                        evaluationService.createEvaluation(
                                EvaluationMapper.toEntity(dto)
                        )
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<EvaluationDTO> update(
            @PathVariable Long id,
            @RequestBody EvaluationDTO dto) {

        return ResponseEntity.ok(
                EvaluationMapper.toDTO(
                        evaluationService.updateEvaluation(
                                id,
                                EvaluationMapper.toEntity(dto)
                        )
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvaluationDTO> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                EvaluationMapper.toDTO(
                        evaluationService.findById(id)
                )
        );
    }

    @GetMapping("/practice/{practiceId}")
    public ResponseEntity<List<EvaluationDTO>> findByPractice(
            @PathVariable Long practiceId) {

        return ResponseEntity.ok(
                evaluationService.findByPractice(practiceId)
                        .stream()
                        .map(EvaluationMapper::toDTO)
                        .toList()
        );
    }

    @GetMapping("/average/{practiceId}")
    public ResponseEntity<Double> average(
            @PathVariable Long practiceId) {

        return ResponseEntity.ok(
                evaluationService.calculateAverageScore(
                        practiceId)
        );
    }
}