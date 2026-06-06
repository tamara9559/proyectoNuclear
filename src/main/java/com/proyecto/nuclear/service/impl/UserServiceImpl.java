package com.proyecto.nuclear.service.impl;

import com.proyecto.nuclear.entity.User;
import com.proyecto.nuclear.enums.RolUsuario;
import com.proyecto.nuclear.exception.ResourceNotFoundException;
import com.proyecto.nuclear.repository.UserRepository;
import com.proyecto.nuclear.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        user.setFechaCreacion(LocalDateTime.now());
        user.setEstado(true);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        User existing = findById(id);

        existing.setNombres(user.getNombres());
        existing.setApellidos(user.getApellidos());
        existing.setTelefono(user.getTelefono());
        existing.setRol(user.getRol());

        return userRepository.save(existing);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByCorreo(email)
                .orElseThrow(() -> new ResourceNotFoundException("Correo no encontrado"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void changePassword(Long id, String password) {
        User user = findById(id);
        user.setPasswordHash(password);
        userRepository.save(user);
    }

    @Override
    public void activateUser(Long id) {
        User user = findById(id);
        user.setEstado(true);
        userRepository.save(user);
    }

    @Override
    public void deactivateUser(Long id) {
        User user = findById(id);
        user.setEstado(false);
        userRepository.save(user);
    }

    @Override
    public void updateLastAccess(Long id) {
        User user = findById(id);
        user.setUltimoAcceso(LocalDateTime.now());
        userRepository.save(user);
    }

    @Override
    public boolean isGraduate(Long userId) {

        User user = findById(userId);

        return user.getRol() == RolUsuario.EGRESADO;
    }
}