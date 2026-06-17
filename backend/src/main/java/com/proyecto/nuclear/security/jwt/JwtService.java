package com.proyecto.nuclear.security.jwt;

import io.jsonwebtoken.*;

import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

import java.util.Date;

@Service
public class JwtService {

    private final String SECRET=
            "proyecto_nuclear_seguridad_jwt_2026";

    private SecretKey key(){

        return Keys.hmacShaKeyFor(
                SECRET.getBytes()
        );

    }

    public String generateToken(
            String email
    ){

        return Jwts.builder()

                .subject(email)

                .issuedAt(
                        new Date()
                )

                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        +86400000
                        )
                )

                .signWith(
                        key()
                )

                .compact();

    }

    public String extractEmail(
            String token
    ){

        return Jwts.parser()

                .verifyWith(
                        key()
                )

                .build()

                .parseSignedClaims(
                        token
                )

                .getPayload()

                .getSubject();

    }

    public boolean validate(
            String token
    ){

        try{

            Jwts.parser()

                    .verifyWith(
                            key()
                    )

                    .build()

                    .parseSignedClaims(
                            token
                    );

            return true;

        }

        catch(Exception e){

            return false;

        }

    }

}