package com.proyecto.nuclear.security.service;

import com.proyecto.nuclear.entity.User;
import com.proyecto.nuclear.repository.UserRepository;
import com.proyecto.nuclear.security.dto.LoginRequest;
import com.proyecto.nuclear.security.dto.LoginResponse;
import com.proyecto.nuclear.security.jwt.JwtService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final BCryptPasswordEncoder encoder =
            new BCryptPasswordEncoder();

    public LoginResponse login(
            LoginRequest request
    ) {

        User user =
                userRepository
                        .findByCorreo(
                                request.getCorreo()
                        )
                        .orElseThrow(
                                () ->
                                        new RuntimeException(
                                                "Usuario no encontrado"
                                        )
                        );

        if (
                !encoder.matches(
                        request.getPassword(),
                        user.getPasswordHash()
                )
        ) {

            throw new RuntimeException(
                    "Contraseña incorrecta"
            );

        }

        String token =
                jwtService
                        .generateToken(
                                user.getCorreo()
                        );

        return LoginResponse.builder()

                .token(
                        token
                )

                .userId(
                        user.getId()
                )

                .correo(
                        user.getCorreo()
                )

                .rol(
                        user.getRol().name()
                )

                .build();

    }

}