package com.proyecto.nuclear.service;

public interface SelectionService {

    void sendResumeToCompany(
            Long studentId,
            Long vacancyId);

    void acceptCandidate(
            Long studentId,
            Long vacancyId);

    void rejectCandidate(
            Long studentId,
            Long vacancyId);

    void finalizeAssignment(
            Long studentId,
            Long vacancyId);

    void updateSelectionStatus(
            Long studentId,
            Long vacancyId,
            String status);
}
