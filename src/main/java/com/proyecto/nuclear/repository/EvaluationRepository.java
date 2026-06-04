package com.proyecto.nuclear.repository;

import com.proyecto.nuclear.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
}
