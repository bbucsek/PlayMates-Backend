package com.playmates.playmates.service;

import com.playmates.playmates.model.Event;
import com.playmates.playmates.model.credentials.EventCredentials;
import com.playmates.playmates.model.generated.GamesItem;
import com.playmates.playmates.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    public void addEvent(EventCredentials event) {
        GamesItem gamesItem = new GamesItem();
        gamesItem.setName(event.getGame());
        Event newEvent = Event.builder()
                .eventDate(event.getDate())
                .memberLimit(event.getLimit())
                .game(event.getGame())
                .build();
        eventRepository.saveAndFlush(newEvent);
    }
}
