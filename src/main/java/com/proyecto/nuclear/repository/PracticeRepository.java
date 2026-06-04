package com.proyecto.nuclear.repository;

import com.proyecto.nuclear.entity.Practice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PracticeRepository extends JpaRepository<Practice, Long> {
}