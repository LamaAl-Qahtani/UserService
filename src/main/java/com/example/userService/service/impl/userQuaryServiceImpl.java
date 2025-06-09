package com.example.userService.service.impl;

import com.example.userService.model.AppUser;
import com.example.userService.repo.userRepo;
import com.example.userService.service.userQuaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class userQuaryServiceImpl implements userQuaryService {
    @Autowired
    private userRepo userrepo;
    @Override
    public List<AppUser> getAllUsers() {
        return this.userrepo.findByActiveTrue();
    }

    @Override
    public Optional<AppUser> getUsersById(Long id) {
        Optional<AppUser> user=this.userrepo.findByIdAndActiveTrue(id);
        return (user.isPresent())?user:null;
    }
}
