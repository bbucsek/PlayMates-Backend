package com.playmates.playmates.service;

import com.playmates.playmates.model.AppUser;
import com.playmates.playmates.model.Event;
import com.playmates.playmates.model.EventBoardGame;
import com.playmates.playmates.model.EventForFrontend;
import com.playmates.playmates.model.credentials.EventCredentials;
import com.playmates.playmates.repository.AppUserRepository;
import com.playmates.playmates.repository.EventRepository;
import com.playmates.playmates.util.Converter;
import com.playmates.playmates.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    Converter converter;

    public void addEvent(EventCredentials event) {
        String name = Util.getUserFromContext();
        AppUser appUser = appUserRepository.findByUsername(name).get();

        List<EventBoardGame> games = event.getGames().stream().map(game -> {
            EventBoardGame obj = EventBoardGame.builder()
                    .apiId(game.getId())
                    .name(game.getName())
                    .build();
            return obj;
        }).collect(Collectors.toList());

        Event newEvent = Event.builder()
                .eventDate(event.getDate())
                .hostId(appUser.getId())
                .memberLimit(event.getLimit())
                .games(games)
                .build();
        eventRepository.saveAndFlush(newEvent);
    }

    public Set<EventForFrontend> getMyEvents() {

        String name = Util.getUserFromContext();
        AppUser user = appUserRepository.findByUsername(name).get();
        Set<Event> events = eventRepository.findByHostId(user.getId());

        return converter.getConvertedEvent(events);

    }
}
