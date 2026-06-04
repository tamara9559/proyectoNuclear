package com.proyecto.nuclear.repository;


import com.proyecto.nuclear.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
