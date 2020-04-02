package com.playmates.playmates.repository;

import com.playmates.playmates.model.AppUser;
import com.playmates.playmates.model.BoardGameFiltered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);

    @Query("SELECT username FROM AppUser u WHERE u.id = :id")
    String findUsernameById(Long id);

    @Query("SELECT favouriteBoardGames from AppUser")
    Set<BoardGameFiltered> getAllUserFavouriteGames();
}
