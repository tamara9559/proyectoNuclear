package com.proyecto.nuclear.service.impl;

import com.proyecto.nuclear.entity.Monitoring;

import java.util.List;

public interface MonitoringServiceImpl {

    Monitoring registerVisit(
            Monitoring monitoring);

    Monitoring registerObservation(
            Monitoring monitoring);

    Monitoring registerMeeting(
            Monitoring monitoring);

    Monitoring registerCall(
            Monitoring monitoring);

    List<Monitoring> findByPractice(
            Long practiceId);

    List<Monitoring> findByCoordinator(
            Long coordinatorId);

    List<Monitoring> getPracticeHistory(
            Long practiceId);
}
