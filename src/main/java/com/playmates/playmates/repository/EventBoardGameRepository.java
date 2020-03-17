package com.playmates.playmates.repository;

import com.playmates.playmates.model.Event;
import com.playmates.playmates.model.EventBoardGame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface EventBoardGameRepository extends JpaRepository<EventBoardGame, Long> {
}
