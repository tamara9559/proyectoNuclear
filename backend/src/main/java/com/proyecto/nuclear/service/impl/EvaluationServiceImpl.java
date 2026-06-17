package com.proyecto.nuclear.service.impl;

import com.proyecto.nuclear.entity.Evaluation;
import com.proyecto.nuclear.exception.ResourceNotFoundException;
import com.proyecto.nuclear.repository.EvaluationRepository;
import com.proyecto.nuclear.service.EvaluationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EvaluationServiceImpl implements EvaluationService {

    private final EvaluationRepository evaluationRepository;

    @Override
    public Evaluation createEvaluation(
            Evaluation evaluation) {

        return evaluationRepository.save(evaluation);
    }

    @Override
    public Evaluation updateEvaluation(
            Long id,
            Evaluation evaluation
    ) {
        Evaluation existing =
                findById(id);
        if (evaluation.getCalificacion() != null) {
            existing.setCalificacion(
                    evaluation.getCalificacion()
            );
        }
        if (evaluation.getFortalezas() != null) {
            existing.setFortalezas(
                    evaluation.getFortalezas()
            );
        }
        if (evaluation.getOportunidadesMejora() != null) {
            existing.setOportunidadesMejora(
                    evaluation.getOportunidadesMejora()
            );
        }
        if (evaluation.getObservaciones() != null) {
            existing.setObservaciones(
                    evaluation.getObservaciones()
            );
        }
        return evaluationRepository.save(
                existing
        );
    }

    @Override
    public Evaluation findById(Long id) {

        return evaluationRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Evaluación no encontrada: " + id));
    }

    @Override
    public List<Evaluation> findByPractice(Long practiceId) {

        return evaluationRepository
                .findByPracticaId(practiceId);
    }

    @Override
    public Double calculateAverageScore(Long practiceId) {

        List<Evaluation> evaluations =
                findByPractice(practiceId);

        return evaluations.stream()
                .filter(e -> e.getCalificacion() != null)
                .mapToDouble(e ->
                        e.getCalificacion().doubleValue())
                .average()
                .orElse(0.0);
    }
}