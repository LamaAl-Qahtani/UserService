package com.example.userService.service.impl;

import com.example.userService.model.AppUser;
import com.example.userService.repo.userRepo;
import com.example.userService.service.userCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class userCommandServiceImpl implements userCommandService {
    @Autowired
    private userRepo userrepo;

    @Override
    public AppUser createUser(String userName, String lastNmae) {
        AppUser appUser = new AppUser(userName, lastNmae);
        return this.userrepo.save(appUser);
    }

    @Override
    public AppUser createActiveUser(String userName, String lastNmae) {
        AppUser appUser = new AppUser(userName, lastNmae, true);
        return this.userrepo.save(appUser);
    }

    @Override
    public ResponseEntity<AppUser> updateUser(AppUser userToEdit, Long userId) {
        return this.userrepo.findByIdAndActiveTrue(userId).map(u -> {
            u.setName(userToEdit.getName());
            u.setLastname(u.getLastname());
            return ResponseEntity.ok(this.userrepo.save(u));

        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public void deleteUser(Long userId) {
        AppUser appUser = this.userrepo.findById(userId).orElse(null);
        if (appUser != null) {
            this.userrepo.delete(appUser);
        }
    }

    @Override
    public ResponseEntity<AppUser> deleteActiveUser(Long userId) {
        return this.userrepo.findById(userId).map(u -> {
            u.setActive(false);
            return ResponseEntity.ok(this.userrepo.save(u));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
