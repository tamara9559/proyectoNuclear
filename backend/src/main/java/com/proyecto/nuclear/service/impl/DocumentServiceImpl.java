package com.proyecto.nuclear.service.impl;

import com.proyecto.nuclear.entity.Document;
import com.proyecto.nuclear.exception.ResourceNotFoundException;
import com.proyecto.nuclear.repository.DocumentRepository;
import com.proyecto.nuclear.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;

    @Override
    public Document uploadDocument(Document document) {

        document.setFechaCarga(LocalDateTime.now());

        return documentRepository.save(document);
    }

    @Override
    public Document findById(Long id) {

        return documentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Documento no encontrado: " + id));
    }

    @Override
    public List<Document> findByStudent(Long studentId) {
        return documentRepository.findByEstudianteId(studentId);
    }

    @Override
    public List<Document> findByCompany(Long companyId) {
        return documentRepository.findByEmpresaId(companyId);
    }

    @Override
    public List<Document> findByAgreement(Long agreementId) {
        return documentRepository.findByConvenioId(agreementId);
    }

    @Override
    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }

    @Override
    public String generateAgreementDocument(Long agreementId) {

        return "Convenio generado para id: "
                + agreementId;
    }

    @Override
    public String generateLearningContract(Long practiceId) {

        return "Contrato de aprendizaje generado para práctica: "
                + practiceId;
    }

    @Override
    public String generateMobilityForm(Long practiceId) {

        return "Formulario de movilidad generado para práctica: "
                + practiceId;
    }
}