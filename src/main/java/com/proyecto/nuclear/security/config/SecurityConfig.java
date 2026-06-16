package com.proyecto.nuclear.security.config;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.*;

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.*;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.*;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.proyecto.nuclear.security.jwt.JwtFilter;

@Configuration

@EnableMethodSecurity

@RequiredArgsConstructor

public class SecurityConfig {

    private final JwtFilter jwt;

    @Bean
    SecurityFilterChain filter(

            HttpSecurity http

    )

            throws Exception {

        http.cors(
                        cors ->
                        {
                        }
                )

                .csrf(
                        c ->
                                c.disable()
                )

                .sessionManagement(

                        s ->

                                s.sessionCreationPolicy(

                                        SessionCreationPolicy.STATELESS

                                )

                )

                .authorizeHttpRequests(

                        auth ->

                                auth

                                        .requestMatchers(
                                                "/api/auth/**",
                                                "/api/vacancies/open"
                                        )

                                        .permitAll()

                                        .requestMatchers(
                                                "/api/users/email/**"
                                        )
                                        .authenticated()

                                        .requestMatchers(
                                                "/api/users/**"
                                        )
                                        .hasRole(
                                                "ADMIN"
                                        )

                                        .requestMatchers(
                                                "/api/monitorings/**"
                                        )

                                        .hasAnyRole(

                                                "ADMIN",

                                                "COORDINADOR"

                                        ).requestMatchers("/api/companies/**")
                                        .hasAnyRole("ADMIN", "COORDINADOR","EMPRESA")

                                        .anyRequest()

                                        .authenticated()

                )

                .addFilterBefore(

                        jwt,

                        UsernamePasswordAuthenticationFilter.class

                );

        return http.build();

    }

    @Bean
    PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();

    }

}