package com.example.userService.service;

import com.example.userService.model.AppUser;
import org.springframework.http.ResponseEntity;

public interface userCommandService {
    AppUser createUser(String userName, String lastNmae);

    AppUser createActiveUser(String userName, String lastNmae);

    ResponseEntity<AppUser> updateUser(AppUser userToEdit, Long userId);

    void deleteUser(Long userId);

    ResponseEntity<AppUser> deleteActiveUser(Long userId);


}
