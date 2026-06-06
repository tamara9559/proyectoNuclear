package com.proyecto.nuclear.service;

import com.proyecto.nuclear.entity.User;
import java.util.List;

public interface UserService {

    User createUser(User user);

    User updateUser(Long id, User user);

    User findById(Long id);

    User findByEmail(String email);

    List<User> findAll();

    void changePassword(Long id, String password);

    void activateUser(Long id);

    void deactivateUser(Long id);

    void updateLastAccess(Long id);

    boolean isGraduate(Long userId);
}
