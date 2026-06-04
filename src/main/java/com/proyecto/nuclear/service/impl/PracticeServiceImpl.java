package com.proyecto.nuclear.service.impl;

import com.proyecto.nuclear.entity.Practice;

import java.util.List;

public interface PracticeServiceImpl {

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
