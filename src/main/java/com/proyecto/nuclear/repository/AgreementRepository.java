package com.proyecto.nuclear.repository;

import com.proyecto.nuclear.entity.Agreement;
import com.proyecto.nuclear.enums.TipoConvenio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgreementRepository extends JpaRepository<Agreement, Long> {

    List<Agreement> findByEmpresaId(
            Long empresaId);

    List<Agreement> findByTipoConvenio(
            TipoConvenio tipoConvenio);

    List<Agreement> findByValidado(
            Boolean validado);

}
