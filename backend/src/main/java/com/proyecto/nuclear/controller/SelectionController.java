package com.proyecto.nuclear.controller;

import com.proyecto.nuclear.service.SelectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/selections")
@RequiredArgsConstructor
public class SelectionController {

    private final SelectionService selectionService;

    @PostMapping("/send-resume")
    public ResponseEntity<Void> sendResume(
            @RequestParam Long studentId,
            @RequestParam Long vacancyId) {

        selectionService.sendResumeToCompany(
                studentId,
                vacancyId);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/accept")
    public ResponseEntity<Void> acceptCandidate(
            @RequestParam Long studentId,
            @RequestParam Long vacancyId) {

        selectionService.acceptCandidate(
                studentId,
                vacancyId);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/reject")
    public ResponseEntity<Void> rejectCandidate(
            @RequestParam Long studentId,
            @RequestParam Long vacancyId) {

        selectionService.rejectCandidate(
                studentId,
                vacancyId);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/finalize")
    public ResponseEntity<Void> finalizeAssignment(
            @RequestParam Long studentId,
            @RequestParam Long vacancyId) {

        selectionService.finalizeAssignment(
                studentId,
                vacancyId);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/status")
    public ResponseEntity<Void> updateStatus(
            @RequestParam Long studentId,
            @RequestParam Long vacancyId,
            @RequestParam String status) {

        selectionService.updateSelectionStatus(
                studentId,
                vacancyId,
                status);

        return ResponseEntity.ok().build();
    }
}