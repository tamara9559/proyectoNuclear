package com.proyecto.nuclear.repository;

import com.proyecto.nuclear.entity.User;
import com.proyecto.nuclear.enums.RolUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByCorreo(String correo);

    boolean existsByCorreo(String correo);

    List<User> findByRol(RolUsuario rol);

}
