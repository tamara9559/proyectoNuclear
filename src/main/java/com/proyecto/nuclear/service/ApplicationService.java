package com.proyecto.nuclear.service;

import com.proyecto.nuclear.entity.Application;

import java.util.List;

public interface ApplicationService {

    Application apply(
            Long userId,
            Long vacancyId);

    Application findById(
            Long applicationId);

    List<Application> findAll();

    List<Application> findByUser(
            Long userId);

    List<Application> findByVacancy(
            Long vacancyId);

    void acceptApplication(
            Long applicationId);

    void rejectApplication(
            Long applicationId);

    void withdrawApplication(
            Long applicationId);

}