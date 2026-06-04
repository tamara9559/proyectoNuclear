package com.proyecto.nuclear.service;

import com.proyecto.nuclear.entity.Document;

import java.util.List;

public interface DocumentService {

    Document uploadDocument(
            Document document);

    Document findById(Long id);

    List<Document> findByStudent(
            Long studentId);

    List<Document> findByCompany(
            Long companyId);

    List<Document> findByAgreement(
            Long agreementId);

    void deleteDocument(Long id);

    String generateAgreementDocument(
            Long agreementId);

    String generateLearningContract(
            Long practiceId);

    String generateMobilityForm(
            Long practiceId);
}
