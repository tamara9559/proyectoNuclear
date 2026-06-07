package com.proyecto.nuclear.controller;

import com.proyecto.nuclear.DTO.UserDTO;

import com.proyecto.nuclear.mapper.UserMapper;
import com.proyecto.nuclear.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping
    public ResponseEntity<UserDTO> create(
            @RequestBody UserDTO dto) {

        return ResponseEntity.ok(
                UserMapper.toDTO(
                        userService.createUser(
                                UserMapper.toEntity(dto)
                        )
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(
            @PathVariable Long id,
            @RequestBody UserDTO dto) {

        return ResponseEntity.ok(
                UserMapper.toDTO(
                        userService.updateUser(
                                id,
                                UserMapper.toEntity(dto)
                        )
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                UserMapper.toDTO(
                        userService.findById(id)
                )
        );
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {

        return ResponseEntity.ok(
                userService.findAll()
                        .stream()
                        .map(UserMapper::toDTO)
                        .toList()
        );
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> findByEmail(
            @PathVariable String email) {

        return ResponseEntity.ok(
                UserMapper.toDTO(
                        userService.findByEmail(email)
                )
        );
    }

    @PutMapping("/{id}/activate")
    public ResponseEntity<Void> activate(
            @PathVariable Long id) {

        userService.activateUser(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(
            @PathVariable Long id) {

        userService.deactivateUser(id);
        return ResponseEntity.ok().build();
    }
}
