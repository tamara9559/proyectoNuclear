package com.proyecto.nuclear.repository;


import com.proyecto.nuclear.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
