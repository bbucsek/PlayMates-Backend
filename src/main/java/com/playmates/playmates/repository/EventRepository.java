package com.playmates.playmates.repository;

import com.playmates.playmates.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Set<Event> findByHostId(Long hostId);

    Set<Event> findByHostIdIsNot(Long hostId);

}
