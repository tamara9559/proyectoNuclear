package com.proyecto.nuclear.controller;

import com.proyecto.nuclear.DTO.PracticeDTO;
import com.proyecto.nuclear.mapper.PracticeMapper;
import com.proyecto.nuclear.service.PracticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/practices")
@RequiredArgsConstructor
public class PracticeController {

    private final PracticeService practiceService;

    @PostMapping
    public ResponseEntity<PracticeDTO> create(
            @RequestBody PracticeDTO dto) {

        return ResponseEntity.ok(
                PracticeMapper.toDTO(
                        practiceService.createPractice(
                                PracticeMapper.toEntity(dto)
                        )
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<PracticeDTO> update(
            @PathVariable Long id,
            @RequestBody PracticeDTO dto) {

        return ResponseEntity.ok(
                PracticeMapper.toDTO(
                        practiceService.updatePractice(
                                id,
                                PracticeMapper.toEntity(dto)
                        )
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<PracticeDTO> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                PracticeMapper.toDTO(
                        practiceService.findById(id)
                )
        );
    }

    @GetMapping
    public ResponseEntity<List<PracticeDTO>> findAll() {

        return ResponseEntity.ok(
                practiceService.findAll()
                        .stream()
                        .map(PracticeMapper::toDTO)
                        .toList()
        );
    }

    @PutMapping("/{id}/start")
    public ResponseEntity<Void> startPractice(
            @PathVariable Long id) {

        practiceService.startPractice(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/finish")
    public ResponseEntity<Void> finishPractice(
            @PathVariable Long id) {

        practiceService.finishPractice(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/mobility")
    public ResponseEntity<Void> mobility(
            @PathVariable Long id) {

        practiceService.registerMobilityRequest(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<Void> cancel(
            @PathVariable Long id,
            @RequestParam String reason) {

        practiceService.cancelPractice(
                id,
                reason);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/duration")
    public ResponseEntity<Long> duration(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                practiceService.calculateDurationWeeks(id)
        );
    }
}