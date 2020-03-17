package com.playmates.playmates.repository;

import com.playmates.playmates.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);

    @Query("SELECT username FROM AppUser u WHERE u.id = :id")
    String findUsernameById(Long id);
}
