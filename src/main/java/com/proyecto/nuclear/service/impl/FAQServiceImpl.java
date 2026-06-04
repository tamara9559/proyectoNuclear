package com.proyecto.nuclear.service.impl;

import com.proyecto.nuclear.entity.FAQ;
import com.proyecto.nuclear.enums.CategoriaFAQ;

import java.util.List;

public interface FAQServiceImpl {

    FAQ createFaq(FAQ faq);

    FAQ updateFaq(
            Long id,
            FAQ faq);

    FAQ findById(Long id);

    List<FAQ> findAll();

    List<FAQ> findByCategory(
            CategoriaFAQ category);

    void activateFaq(Long id);

    void deactivateFaq(Long id);
}