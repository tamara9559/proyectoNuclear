package com.proyecto.nuclear.service;

import com.proyecto.nuclear.entity.Practice;

import java.util.List;

public interface PracticeService {

    Practice createPractice(Practice practice);

    Practice updatePractice(
            Long id,
            Practice practice);

    Practice findById(Long id);

    List<Practice> findAll();

    void cancelPractice(
            Long practiceId,
            String reason);

    void registerMobilityRequest(
            Long practiceId);

    void startPractice(
            Long practiceId);

    void finishPractice(
            Long practiceId);

    Long calculateDurationWeeks(
            Long practiceId);
}
