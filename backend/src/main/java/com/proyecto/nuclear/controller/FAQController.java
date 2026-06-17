package com.proyecto.nuclear.controller;

import com.proyecto.nuclear.DTO.FAQDTO;
import com.proyecto.nuclear.enums.CategoriaFAQ;
import com.proyecto.nuclear.mapper.FAQMapper;
import com.proyecto.nuclear.service.FAQService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faqs")
@RequiredArgsConstructor
public class FAQController {

    private final FAQService faqService;

    @PostMapping
    public ResponseEntity<FAQDTO> create(
            @RequestBody FAQDTO dto) {

        return ResponseEntity.ok(
                FAQMapper.toDTO(
                        faqService.createFaq(
                                FAQMapper.toEntity(dto)
                        )
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<FAQDTO> update(
            @PathVariable Long id,
            @RequestBody FAQDTO dto) {

        return ResponseEntity.ok(
                FAQMapper.toDTO(
                        faqService.updateFaq(
                                id,
                                FAQMapper.toEntity(dto)
                        )
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<FAQDTO> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                FAQMapper.toDTO(
                        faqService.findById(id)
                )
        );
    }

    @GetMapping
    public ResponseEntity<List<FAQDTO>> findAll() {

        return ResponseEntity.ok(
                faqService.findAll()
                        .stream()
                        .map(FAQMapper::toDTO)
                        .toList()
        );
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<FAQDTO>> findByCategory(
            @PathVariable CategoriaFAQ category) {

        return ResponseEntity.ok(
                faqService.findByCategory(category)
                        .stream()
                        .map(FAQMapper::toDTO)
                        .toList()
        );
    }

    @PutMapping("/{id}/activate")
    public ResponseEntity<Void> activate(
            @PathVariable Long id) {

        faqService.activateFaq(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(
            @PathVariable Long id) {

        faqService.deactivateFaq(id);

        return ResponseEntity.ok().build();
    }
}