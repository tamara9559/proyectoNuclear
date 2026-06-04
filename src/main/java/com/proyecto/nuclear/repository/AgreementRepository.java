package com.proyecto.nuclear.repository;


import com.proyecto.nuclear.entity.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgreementRepository extends JpaRepository<Agreement, Long> {
}
