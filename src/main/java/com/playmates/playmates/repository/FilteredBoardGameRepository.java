package com.playmates.playmates.repository;

import com.playmates.playmates.model.BoardGameFiltered;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilteredBoardGameRepository extends JpaRepository<BoardGameFiltered, Long> {
}
