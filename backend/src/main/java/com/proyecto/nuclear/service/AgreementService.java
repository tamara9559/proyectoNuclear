package com.proyecto.nuclear.service;

import com.proyecto.nuclear.entity.Agreement;

import java.util.List;

public interface AgreementService {

    Agreement createAgreement(
            Agreement agreement);

    Agreement updateAgreement(
            Long id,
            Agreement agreement);

    Agreement findById(Long id);

    List<Agreement> findAll();

    void validateCompanyRequirements(
            Long agreementId);

    void signByCompany(
            Long agreementId);

    void signByUniversity(
            Long agreementId);

    void signByStudent(
            Long agreementId);

    void activateAgreement(
            Long agreementId);
}
