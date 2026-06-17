package com.proyecto.nuclear.controller;

import com.proyecto.nuclear.DTO.MonitoringDTO;
import com.proyecto.nuclear.mapper.MonitoringMapper;
import com.proyecto.nuclear.service.MonitoringService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monitorings")
@RequiredArgsConstructor
public class MonitoringController {

    private final MonitoringService monitoringService;

    @PostMapping("/visit")
    public ResponseEntity<MonitoringDTO> registerVisit(
            @RequestBody MonitoringDTO dto) {

        return ResponseEntity.ok(
                MonitoringMapper.toDTO(
                        monitoringService.registerVisit(
                                MonitoringMapper.toEntity(dto)
                        )
                )
        );
    }

    @PostMapping("/observation")
    public ResponseEntity<MonitoringDTO> registerObservation(
            @RequestBody MonitoringDTO dto) {

        return ResponseEntity.ok(
                MonitoringMapper.toDTO(
                        monitoringService.registerObservation(
                                MonitoringMapper.toEntity(dto)
                        )
                )
        );
    }

    @PostMapping("/meeting")
    public ResponseEntity<MonitoringDTO> registerMeeting(
            @RequestBody MonitoringDTO dto) {

        return ResponseEntity.ok(
                MonitoringMapper.toDTO(
                        monitoringService.registerMeeting(
                                MonitoringMapper.toEntity(dto)
                        )
                )
        );
    }

    @PostMapping("/call")
    public ResponseEntity<MonitoringDTO> registerCall(
            @RequestBody MonitoringDTO dto) {

        return ResponseEntity.ok(
                MonitoringMapper.toDTO(
                        monitoringService.registerCall(
                                MonitoringMapper.toEntity(dto)
                        )
                )
        );
    }

    @GetMapping("/practice/{practiceId}")
    public ResponseEntity<List<MonitoringDTO>> findByPractice(
            @PathVariable Long practiceId) {

        return ResponseEntity.ok(
                monitoringService.findByPractice(practiceId)
                        .stream()
                        .map(MonitoringMapper::toDTO)
                        .toList()
        );
    }

    @GetMapping("/coordinator/{coordinatorId}")
    public ResponseEntity<List<MonitoringDTO>> findByCoordinator(
            @PathVariable Long coordinatorId) {

        return ResponseEntity.ok(
                monitoringService.findByCoordinator(coordinatorId)
                        .stream()
                        .map(MonitoringMapper::toDTO)
                        .toList()
        );
    }

    @GetMapping("/history/{practiceId}")
    public ResponseEntity<List<MonitoringDTO>> history(
            @PathVariable Long practiceId) {

        return ResponseEntity.ok(
                monitoringService.getPracticeHistory(practiceId)
                        .stream()
                        .map(MonitoringMapper::toDTO)
                        .toList()
        );
    }
}