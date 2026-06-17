package com.proyecto.nuclear.security;

import com.proyecto.nuclear.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.*;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl
        implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(
            String correo
    ) {

        return repository

                .findByCorreo(
                        correo
                )

                .map(
                        UserDetailsImpl::new
                )

                .orElseThrow(

                        ()->new
                                UsernameNotFoundException(
                                "Usuario no encontrado"
                        )

                );

    }

}