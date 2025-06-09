package com.example.userService.repo;

import com.example.userService.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface userRepo extends JpaRepository<AppUser,Long> {
    List<AppUser>findByActiveTrue();
    Optional<AppUser>findByIdAndActiveTrue(Long id);
}
