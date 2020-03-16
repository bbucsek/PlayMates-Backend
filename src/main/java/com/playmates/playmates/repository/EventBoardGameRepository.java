package com.playmates.playmates.repository;

import com.playmates.playmates.model.EventBoardGame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventBoardGameRepository extends JpaRepository<EventBoardGame, Long> {
}
