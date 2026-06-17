package com.proyecto.nuclear.repository;

import com.proyecto.nuclear.entity.FAQ;
import com.proyecto.nuclear.enums.CategoriaFAQ;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FAQRepository extends JpaRepository<FAQ, Long> {

    List<FAQ> findByCategoria(
            CategoriaFAQ categoria);

    List<FAQ> findByEstado(
            Boolean estado);

}
