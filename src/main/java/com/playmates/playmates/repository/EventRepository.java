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

    @Modifying
    @Query("update Event e set e.memberIds = :userId where e.id = :eventId")
    void joinEvent(Long eventId, Long userId);

}
