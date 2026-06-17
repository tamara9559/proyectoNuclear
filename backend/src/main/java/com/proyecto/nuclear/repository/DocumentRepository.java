package com.proyecto.nuclear.repository;

import com.proyecto.nuclear.entity.Document;
import com.proyecto.nuclear.enums.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {

    List<Document> findByEstudianteId(
            Long estudianteId);

    List<Document> findByEmpresaId(
            Long empresaId);

    List<Document> findByConvenioId(
            Long convenioId);

    List<Document> findByTipoDocumento(
            TipoDocumento tipoDocumento);

}