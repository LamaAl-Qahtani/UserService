package com.example.userService.controler.Command;

import com.example.userService.dto.userDto;
import com.example.userService.model.AppUser;
import com.example.userService.service.userCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class userCommandControler {
    @Autowired
    private userCommandService usercommandService;

    @PostMapping("/new")
    public ResponseEntity<AppUser> createNewUser(@RequestBody userDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.usercommandService.createUser(dto.getName(), dto.getLastname()));
    }

    @PostMapping("/newactive")
    public ResponseEntity<AppUser> createActiveNewUser(@RequestBody userDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.usercommandService.createActiveUser(dto.getName(), dto.getLastname()));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<AppUser> updateUser(@RequestBody AppUser userToEdit, @PathVariable Long id) {
        return this.usercommandService.updateUser(userToEdit, id);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<AppUser> deleteUser(@PathVariable Long id) {
        this.usercommandService.deleteUser(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/deleteactive/{id}")
    public ResponseEntity<AppUser> deleteActiveUser(@PathVariable Long id) {
        return this.usercommandService.deleteActiveUser(id);

    }


}
