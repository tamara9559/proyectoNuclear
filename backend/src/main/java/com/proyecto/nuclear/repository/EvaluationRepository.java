package com.proyecto.nuclear.repository;

import com.proyecto.nuclear.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {

    List<Evaluation> findByPracticaId(
            Long practicaId);

}
