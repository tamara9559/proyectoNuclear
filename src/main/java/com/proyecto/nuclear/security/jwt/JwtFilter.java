package com.proyecto.nuclear.security.jwt;

import jakarta.servlet.*;

import jakarta.servlet.http.*;

import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import org.springframework.stereotype.Component;

import org.springframework.web.filter.OncePerRequestFilter;

import com.proyecto.nuclear.security.UserDetailsServiceImpl;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter
        extends OncePerRequestFilter {

    private final JwtService jwt;

    private final UserDetailsServiceImpl users;

    @Override
    protected void doFilterInternal(

            HttpServletRequest request,

            HttpServletResponse response,

            FilterChain chain

    )

            throws ServletException,
            IOException {

        String header =
                request.getHeader(
                        "Authorization"
                );

        if(

                header==null

                        ||

                        !header.startsWith(
                                "Bearer "
                        )

        ){

            chain.doFilter(
                    request,
                    response
            );

            return;

        }

        String token =
                header.substring(
                        7
                );

        if(

                jwt.validate(
                        token
                )

        ){

            String email =
                    jwt.extractEmail(
                            token
                    );

            UserDetails user =

                    users

                            .loadUserByUsername(
                                    email
                            );

            UsernamePasswordAuthenticationToken auth =

                    new UsernamePasswordAuthenticationToken(

                            user,

                            null,

                            user.getAuthorities()

                    );

            auth.setDetails(

                    new WebAuthenticationDetailsSource()

                            .buildDetails(
                                    request
                            )

            );

            SecurityContextHolder

                    .getContext()

                    .setAuthentication(
                            auth
                    );

        }

        chain.doFilter(
                request,
                response
        );

    }

}