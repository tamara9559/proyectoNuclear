package com.proyecto.nuclear.controller;

import com.proyecto.nuclear.DTO.CompanyDTO;
import com.proyecto.nuclear.mapper.CompanyMapper;
import com.proyecto.nuclear.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    public ResponseEntity<CompanyDTO> create(
            @RequestBody CompanyDTO dto) {

        return ResponseEntity.ok(
                CompanyMapper.toDTO(
                        companyService.createCompany(
                                CompanyMapper.toEntity(dto)
                        )
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyDTO> update(
            @PathVariable Long id,
            @RequestBody CompanyDTO dto) {

        return ResponseEntity.ok(
                CompanyMapper.toDTO(
                        companyService.updateCompany(
                                id,
                                CompanyMapper.toEntity(dto)
                        )
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDTO> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                CompanyMapper.toDTO(
                        companyService.findById(id)
                )
        );
    }

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> findAll() {

        return ResponseEntity.ok(
                companyService.findAll()
                        .stream()
                        .map(CompanyMapper::toDTO)
                        .toList()
        );
    }

    @GetMapping("/nit/{nit}")
    public ResponseEntity<CompanyDTO> findByNit(
            @PathVariable String nit) {

        return ResponseEntity.ok(
                CompanyMapper.toDTO(
                        companyService.findByNit(nit)
                )
        );
    }

    @GetMapping("/sector/{sector}")
    public ResponseEntity<List<CompanyDTO>> findBySector(
            @PathVariable String sector) {

        return ResponseEntity.ok(
                companyService.searchBySector(sector)
                        .stream()
                        .map(CompanyMapper::toDTO)
                        .toList()
        );
    }
}