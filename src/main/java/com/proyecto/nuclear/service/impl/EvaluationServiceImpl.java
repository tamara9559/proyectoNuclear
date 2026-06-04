package com.proyecto.nuclear.service.impl;


import com.proyecto.nuclear.entity.Evaluation;

import java.util.List;

public interface EvaluationServiceImpl {

    Evaluation createEvaluation(
            Evaluation evaluation);

    Evaluation updateEvaluation(
            Long id,
            Evaluation evaluation);

    Evaluation findById(Long id);

    List<Evaluation> findByPractice(
            Long practiceId);

    Double calculateAverageScore(
            Long practiceId);
}
