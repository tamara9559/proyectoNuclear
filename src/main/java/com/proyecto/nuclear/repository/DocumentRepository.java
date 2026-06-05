package com.proyecto.nuclear.repository;

import com.proyecto.nuclear.entity.Document;
import com.proyecto.nuclear.enums.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {

    List<Document> findByEstudianteIdEstudiante(
            Long estudianteId);

    List<Document> findByEmpresaIdEmpresa(
            Long empresaId);

    List<Document> findByConvenioIdConvenio(
            Long convenioId);

    List<Document> findByTipoDocumento(
            TipoDocumento tipoDocumento);

}