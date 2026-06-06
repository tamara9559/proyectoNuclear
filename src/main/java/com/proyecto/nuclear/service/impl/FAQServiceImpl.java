package com.proyecto.nuclear.service.impl;

import com.proyecto.nuclear.entity.FAQ;
import com.proyecto.nuclear.enums.CategoriaFAQ;
import com.proyecto.nuclear.exception.ResourceNotFoundException;
import com.proyecto.nuclear.repository.FAQRepository;
import com.proyecto.nuclear.service.FAQService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FAQServiceImpl implements FAQService {

    private final FAQRepository faqRepository;

    @Override
    public FAQ createFaq(FAQ faq) {

        faq.setEstado(true);
        faq.setFechaCreacion(LocalDateTime.now());

        return faqRepository.save(faq);
    }

    @Override
    public FAQ updateFaq(Long id, FAQ faq) {

        FAQ existing = findById(id);

        existing.setPregunta(faq.getPregunta());
        existing.setRespuesta(faq.getRespuesta());
        existing.setCategoria(faq.getCategoria());

        return faqRepository.save(existing);
    }

    @Override
    public FAQ findById(Long id) {

        return faqRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "FAQ no encontrada: " + id));
    }

    @Override
    public List<FAQ> findAll() {
        return faqRepository.findAll();
    }

    @Override
    public List<FAQ> findByCategory(CategoriaFAQ category) {
        return faqRepository.findByCategoria(category);
    }

    @Override
    public void activateFaq(Long id) {

        FAQ faq = findById(id);

        faq.setEstado(true);

        faqRepository.save(faq);
    }

    @Override
    public void deactivateFaq(Long id) {

        FAQ faq = findById(id);

        faq.setEstado(false);

        faqRepository.save(faq);
    }
}