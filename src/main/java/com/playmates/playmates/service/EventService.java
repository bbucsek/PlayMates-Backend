package com.playmates.playmates.service;

import com.playmates.playmates.model.AppUser;
import com.playmates.playmates.model.Event;
import com.playmates.playmates.model.credentials.EventCredentials;
import com.playmates.playmates.model.generated.GamesItem;
import com.playmates.playmates.repository.AppUserRepository;
import com.playmates.playmates.repository.EventRepository;
import com.playmates.playmates.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    AppUserRepository appUserRepository;

    public void addEvent(EventCredentials event) {
        String name = Util.getUserFromContext();
        AppUser appUser = appUserRepository.findByUsername(name).get();
        GamesItem gamesItem = new GamesItem();
        gamesItem.setName(event.getGame());
        Event newEvent = Event.builder()
                .eventDate(event.getDate())
                .host(appUser)
                .memberLimit(event.getLimit())
                .game(event.getGame())
                .build();
        eventRepository.saveAndFlush(newEvent);
    }
}
