package com.proyecto.nuclear.service.impl;

import com.proyecto.nuclear.entity.Agreement;
import com.proyecto.nuclear.exception.ResourceNotFoundException;
import com.proyecto.nuclear.repository.AgreementRepository;
import com.proyecto.nuclear.service.AgreementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgreementServiceImpl implements AgreementService {

    private final AgreementRepository agreementRepository;

    @Override
    public Agreement createAgreement(Agreement agreement) {
        return agreementRepository.save(agreement);
    }

    @Override
    public Agreement updateAgreement(
            Long id,
            Agreement agreement
    ) {
        Agreement existing =
                findById(id);
        if (agreement.getTipoConvenio() != null) {
            existing.setTipoConvenio(
                    agreement.getTipoConvenio()
            );
        }
        if (agreement.getFechaInicio() != null) {
            existing.setFechaInicio(
                    agreement.getFechaInicio()
            );
        }
        if (agreement.getFechaFin() != null) {
            existing.setFechaFin(
                    agreement.getFechaFin()
            );
        }
        if (agreement.getObservaciones() != null) {
            existing.setObservaciones(
                    agreement.getObservaciones()
            );
        }
        return agreementRepository.save(
                existing
        );
    }

    @Override
    public Agreement findById(Long id) {

        return agreementRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Convenio no encontrado: " + id));
    }

    @Override
    public List<Agreement> findAll() {
        return agreementRepository.findAll();
    }

    @Override
    public void validateCompanyRequirements(Long agreementId) {

        Agreement agreement = findById(agreementId);

        agreement.setValidado(true);

        agreementRepository.save(agreement);
    }

    @Override
    public void signByCompany(Long agreementId) {

        Agreement agreement = findById(agreementId);

        agreement.setFirmadoEmpresa(true);

        agreementRepository.save(agreement);
    }

    @Override
    public void signByUniversity(Long agreementId) {

        Agreement agreement = findById(agreementId);

        agreement.setFirmadoUniversidad(true);

        agreementRepository.save(agreement);
    }

    @Override
    public void signByStudent(Long agreementId) {

        Agreement agreement = findById(agreementId);

        agreement.setFirmadoEstudiante(true);

        agreementRepository.save(agreement);
    }

    @Override
    public void activateAgreement(
            Long agreementId
    ) {

        Agreement agreement =
                findById(
                        agreementId
                );

        if (
                !Boolean.TRUE.equals(
                        agreement.getValidado()
                )
                        ||
                        !Boolean.TRUE.equals(
                                agreement.getFirmadoEmpresa()
                        )
                        ||
                        !Boolean.TRUE.equals(
                                agreement.getFirmadoUniversidad()
                        )
                        ||
                        !Boolean.TRUE.equals(
                                agreement.getFirmadoEstudiante()
                        )
        ) {

            throw new IllegalStateException(
                    "El convenio no cumple condiciones para activarse"
            );

        }

        agreement.setEstado(
                "ACTIVO"
        );

        agreementRepository.save(
                agreement);

    }
}
