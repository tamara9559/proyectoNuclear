package com.proyecto.nuclear.security;

import com.proyecto.nuclear.entity.User;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;

import java.util.List;

@RequiredArgsConstructor
public class UserDetailsImpl
        implements UserDetails {

    private final User user;

    @Override
    public Collection<
            ? extends GrantedAuthority
            > getAuthorities() {

        return List.of(

                new SimpleGrantedAuthority(
                        "ROLE_" +
                                user.getRol().name()
                )

        );

    }

    @Override
    public String getPassword() {

        return user.getPasswordHash();

    }

    @Override
    public String getUsername() {

        return user.getCorreo();

    }

    @Override
    public boolean isEnabled() {

        return Boolean.TRUE.equals(
                user.getEstado()
        );

    }

}