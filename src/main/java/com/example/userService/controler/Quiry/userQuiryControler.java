package com.example.userService.controler.Quiry;

import com.example.userService.model.AppUser;
import com.example.userService.service.userQuaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class userQuiryControler {
    @Autowired
    private userQuaryService userquaryService;

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        Optional<AppUser> user = this.userquaryService.getUsersById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        } else return ResponseEntity.ok(user);
    }
    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        List<AppUser> users = this.userquaryService.getAllUsers();
        if (users.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else return ResponseEntity.ok(users);
    }
}

