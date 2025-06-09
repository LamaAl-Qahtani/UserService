package com.example.userService.service;

import com.example.userService.model.AppUser;

import java.util.List;
import java.util.Optional;

public interface userQuaryService {
    List<AppUser> getAllUsers();
    Optional<AppUser> getUsersById(Long id);
}
